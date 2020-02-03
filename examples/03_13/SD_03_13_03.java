// array is sorted, assume no duplicate
// number of pairs with diff == target
public static int NumberOfPairs(int[] array, int target) {
	int count = 0;
	int i = 0;
	int j = 1;
	while (j < array.length) {   // for each j
		int diff = array[j] - array[i];
		if (diff == target) {
			count++;
			j++;
		} else if (diff < target) {
			j++;
		} else {
			i++;
		}
	}
	return count;
}

// number of pairs with diff > target
// x: 第一个leftmost index where array[j] - array[i] <= target
// x - 1: 最后一个rightmost index where array[j] - array[i] > target
public static int NumberOfPairs2(int[] array, int target) {
	int count = 0;
	int i = 0;
	int j = 1;
	while (j < array.length) {
		int diff = array[j] - array[i];
		if (diff >= target) {
			j++;
			count += i; 
		} else {
			i++;
		}
	}
	return count;
}

public static int NumberOfPairs3(int[] array, int target) {
	Map<Integer, Integer> map = new HashMap<>();
	int count = 0;
	for (int element : array) {
		count += map.getOrDefault(element - target, 0);
		count += map.getOrDefault(element + target, 0);
		map.put(element, map.getOrDefault(element, 0) + 1);
	}
	return count;
}