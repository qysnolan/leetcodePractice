package yunsheng.leetcode.practise;

public class Searcha2DMatrix {
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0)
			return false;
		
		int m = matrix.length;
		int n = matrix[0].length;
		int start = 0;
		int end = m - 1;
		int mid = 0;
		
		while(start <= end) {
			mid = (start + end)/2;
			if(matrix[mid][0] == target)
				return true;
			else if(matrix[mid][0] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}
		
		if(end < 0) 
			return false;
		
		int row = end;
		start = 0;
		end = n - 1;
		while(start <= end) {
			mid = (start + end)/2;
			if(matrix[row][mid] == target)
				return true;
			else if(matrix[row][mid] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}			
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
		int target = 0;
		System.out.println(searchMatrix(matrix, target));
	}

}
