package yunsheng.leetcode.practise;

import java.util.Arrays;

public class SetMatrixZeroes {

	public static void setZeroes(int[][] matrix) {
		if(matrix.length == 0 || matrix[0].length == 0)
			return;
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		boolean[] row = new boolean[m];
		boolean[] col = new boolean[n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		for(int i = 0; i < m; i++) 
			for(int j = 0; j < n; j++) 
				if(row[i] || col[j]) 
					matrix[i][j] = 0;

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1, 3, 0, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
		for (int[] arr : matrix) 
            System.out.println(Arrays.toString(arr));
		setZeroes(matrix);
		for (int[] arr : matrix) 
            System.out.println(Arrays.toString(arr));
	}

}
