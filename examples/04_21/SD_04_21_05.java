import json
import logging
from pyspark.sql.types import StringType, DoubleType
from pyspark.sql.functions import udf, from_unixtime

# setup logging
logger = spark._jvm.org.apache.log4j
logging.getLogger("py4j").setLevel(logging.ERROR)
logging.basicConfig(stream=sys.stdout, level=logging.INFO)
logger = logging.getLogger('streaming_raw_generator')

# UDF methods
# extract userId
def extract_userId_func(value):
    value_dict = json.loads(value)
    key_dict = value_dict['dynamodb']['Keys']
    if 'UserId' in key_dict:
        userId_dict = key_dict['UserId']
        if 'N' in userId_dict:
            return value_dict['dynamodb']['Keys']['UserId']['N']
        else:
            err = "type of UserID is not number"
            logger.error(err)
            return "NULL"
    else:
        err = "key is not UserID"
        logger.error(err)
        return "NULL"

# extract dynamo timestamp
def extract_dynamodb_timestamp_func(value):
  value_dict = json.loads(value)
  value_dynamodb_dict = value_dict['dynamodb']
  if 'ApproximateCreationDateTime' in value_dynamodb_dict:
    return value_dict['dynamodb']['ApproximateCreationDateTime']  # 1575319507.0
  else:
    err = "ApproximateCreationDateTime is not in json payload"
    logger.error(err)
    return "NULL"

# extract NewImage
def extract_newImage_func(value):
  value_dict = json.loads(value)
  value_dynamodb_dict = value_dict['dynamodb']
  if 'NewImage' in value_dynamodb_dict:
    return json.dumps(value_dict['dynamodb']['NewImage'])
  else:
    err = "NewImage is not in json payload"
    logger.error(err)
    return "NULL"


# read data from s3
bucket_name = "" # TODO
key_name = ""    # TODO
input_path = "s3n://" + bucket_name + "/" + key_name
s3_rdd = sc.textFile(input_path)
s3_df = spark.createDataFrame(s3_rdd, StringType())

# ETL
# extract userId
extract_userId_udf = udf(extract_userId_func, StringType())
s3_df2 = s3_df.withColumn('UserId', extract_userId_udf('value'))
# extract timestamp
extract_dynamodb_timestamp_udf = udf(extract_dynamodb_timestamp_func, DoubleType())
s3_df3 = s3_df2.withColumn('unix_timestamp', extract_dynamodb_timestamp_udf('value'))
# convert timestamp to datetime and append a new column
s3_df4 = s3_df3.withColumn('dynamo_timestamp', from_unixtime("unix_timestamp", "yyyy/MM/dd HH:MM:SS"))
# extract NewImage
extract_newImage_udf = udf(extract_newImage_func, StringType())
s3_df5 = s3_df4.withColumn('NewImage', extract_newImage_udf('value'))

s3_sample_df = s3_df5.select('UserId', 'dynamo_timestamp', 'NewImage')

# read data from delta table
history_df = spark.read.table('featuredb_history.features_history')
history_df.registerTempTable("tmp")
history_sample_df = spark.sql("select UserId, dynamo_timestamp, features from tmp where year = 2020 and month = 1 and day = 23") # TODO

# compare two dfs: history_sample_df and s3_sample_df
