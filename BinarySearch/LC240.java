// solution1: 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        } 
        int m = matrix.length;
        int n = matrix[0].length;
        // start point
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        // terminate condition: i = matrix.length / j < 0
        return false;
    }
}

// solution2: binary search
// https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66209/3-different-Binary-Search-Solutions-and-1-O(M+N)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        return searchMatrix(matrix, 0, 0, m - 1, n - 1, target);
    }
    
    private boolean searchMatrix(int[][] matrix, int x1, int y1, int x2, int y2, int target) {
        if (x1 > x2 || y1 > y2 || x2 >= matrix.length || y2 >= matrix[0].length) {
            return false;
        }
        
        if (x1 == x2 && y1 == y2) {
            return matrix[x1][y1] == target;
        }
        int x_mid = (x1 + x2) / 2;
        int y_mid = (y1 + y2) / 2;
        if (matrix[x_mid][y_mid] == target) {
            return true ;          
        } else if (matrix[x_mid][y_mid] > target) {
            return searchMatrix(matrix, x1, y1, x_mid, y_mid, target) ||
                searchMatrix(matrix, x_mid + 1, y1, x2, y_mid, target) ||
                searchMatrix(matrix, x1, y_mid + 1, x_mid, y2, target);
        } else {
            return searchMatrix(matrix, x_mid + 1, y1, x2, y_mid, target) ||
                searchMatrix(matrix, x1, y_mid + 1, x_mid, y2, target) ||
                searchMatrix(matrix, x_mid + 1, y_mid + 1, x2, y2, target);
        }
    }
}