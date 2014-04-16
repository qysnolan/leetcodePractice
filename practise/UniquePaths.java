package yunsheng.leetcode.practise;

public class UniquePaths {
	
	public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0)
            return 0;
        int[][] mat = new int[102][102];
        mat[m][n+1] = 1;
    
        for (int r = m; r >= 1; r--)
            for (int c = n; c >= 1; c--)
                mat[r][c] = mat[r+1][c] + mat[r][c+1];
    
        return mat[1][1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
