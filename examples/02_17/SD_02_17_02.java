package code;

public class SD_02_17_02 {
	// # values <= target
	public static int sum(int[][] matrix, int target) {
		// sanity check
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return -1;
		}
		
		int nums = 0;
		// for each row, find the rightmost element <= target
		int i = 0, j = matrix[0].length - 1;
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

	// # values > target
	public static int sum2(int[][] matrix, int target) {
		int nums = 0;
		int i = 0, j = matrix[0].length - 1;
		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] <= target) {
				nums += (matrix[0].length - (1 + j));
				i++;
			} else {
				j--;
			}
		}
		
		// terminate condition
		// 1. i = matrix.length --> OK
		// 2. j = -1
		int rows = matrix.length - i;
		nums += (rows * matrix[0].length);
		return nums;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
			{3, 5, 8, 12, 18, 19},
			{8, 10, 13, 17, 20, 21},
			{9, 11, 14, 18, 25, 30},
			{13, 15, 18, 22, 26, 32},
			{15, 16, 19, 28, 30, 36},
			{20, 21, 22, 30, 32, 40}
        };
        
        System.out.println(sum(matrix, 17));
	}
}
