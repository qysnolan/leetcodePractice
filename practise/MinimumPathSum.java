package yunsheng.leetcode.practise;

public class MinimumPathSum {

	public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return -1;

        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        if(m == 1 && n == 1)
            return grid[0][0];
        
        if(m > 1)
            for(int i = 1; i < m; i++) 
                sum[i][0] = sum[i-1][0] + grid[i][0];
        if(n > 1)
            for(int j = 1; j < n; j++)
                sum[0][j] = sum[0][j-1] + grid[0][j];
        if(m > 1 && n > 1)
            for(int i = 1; i < m; i++) 
                for(int j = 1; j < n; j++) 
                    sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];

        return sum[m-1][n-1];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
