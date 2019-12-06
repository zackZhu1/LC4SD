package code;

public class SD_02_17_01matrix {
	public static int findPosition(int[][] matrix) {
		// sanity check
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return -1;
		}
		
		int min = matrix[0].length - 1;
		for (int i = 0; i < matrix.length; i++) {
			int pos = findRightMostOne(matrix, i);
			min = pos < min ? pos : min;
		}
		return min;
	}
	
	private static int findRightMostOne(int[][] matrix, int row) {
		int left = 0;
		int right = matrix[0].length - 1;
		
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (matrix[row][mid] == 1) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return matrix[row][left] == 0 ? -1 : left;
	}
	
	public static int findPosition2(int[][] matrix) {
		// find first 0 col
		int i = 0, j = matrix[0].length - 1;
		while (i < matrix.length && j >= 0) {
			if (matrix[i][j]  == 0) {
				i++;
			} else {
				j--;
			}
		}
		// add 1 to return first 1 col
		if (j == -1) return 0;
		else return j + 1;
	}
	
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
							{0, 0, 0, 1, 1},
							{0, 0, 1, 1, 1},
							{0, 0, 0, 0, 1},
							{0, 0, 1, 1, 1}
		                };
		                
        int[][] matrix1 = new int[][]{
			{0, 1, 1, 1},
			{1, 1, 1, 1},
			{0, 0, 0, 0},
			{0, 0, 1, 1}
        };              
		     
        int[][] matrix2 = new int[][]{
			{0, 0, 0, 1},
			{0, 0, 1, 1},
			{0, 0, 0, 0},
			{0, 0, 0, 0}
        }; 
		
		System.out.println(findPosition2(matrix2));
	}
}


// solution1: using binary search 
// solution2: moving from right top element



