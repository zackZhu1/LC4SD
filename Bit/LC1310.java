class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 1; i < arr.length; i++) {
            arr[i] ^= arr[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int startIndex = queries[i][0];
            int endIndex = queries[i][1];
            res[i] = startIndex == 0 ? arr[endIndex] : arr[startIndex - 1] ^ arr[endIndex];
        }
        return res;
    }
}