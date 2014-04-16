package yunsheng.leetcode.practise;

public class EditDistance {
	
	public int minDistance(String word1, String word2) {
		
        int m = word1.length(), 
            n = word2.length();
        int[][] dis = new int[m+1][n+1];
        dis[0][0] = 0;
        
        for(int i = 1; i <= m; i++) 
            dis[i][0] = i;
        for(int j = 1; j <= n; j++)
            dis[0][j] = j;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dis[i][j] = dis[i-1][j-1];
                else
                    dis[i][j] = 1 + Math.min(dis[i-1][j-1], Math.min(dis[i][j-1], dis[i-1][j]));
            }
        }
        
        return dis[m][n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
