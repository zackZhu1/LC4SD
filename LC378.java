// binary search: range not index as search range
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }
        int m = matrix.length, n = matrix[0].length;
        // search range: [min(matrix), max(matrix)]
        // f(x) = # of elements in the matrix <= x, f(x) is increasing
        // find the first x, where f(x) = k
        int left = matrix[0][0];
        int right = matrix[m - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numSmallerEquals(matrix, mid) < k) {
                left = mid + 1;
            } else {
                right = mid; 
            }
        }
        return left;
    }
    
    private int numSmallerEquals(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        int nums = 0;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] <= target) {
                nums += (j + 1);
                i++;
            } else {
                j--;
            }
        }
        return nums;
    }
}

