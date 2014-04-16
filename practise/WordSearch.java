package yunsheng.leetcode.practise;

public class WordSearch {
	
	public static boolean exist(char[][] board, String word) {
		if(board.length == 0 || board[0].length == 0)
			return false;
		if(word == null || word.length() == 0)
			return true;
		
		boolean[][] visited = new boolean[board.length][board[0].length];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(word.charAt(0) == board[i][j]) {
					visited[i][j] = true;
					if(dfs(board, word, visited, i, j, 1))
						return true;
					visited[i][j] = false;
				}						
 			}
		}
		
		return false;
	}
	
	private static boolean dfs(char[][] board, String word, 
			boolean[][] visited, int a, int b, int c) {
		if(c == word.length())
			return true;
		if(a >= board.length || b >= board[0].length || a < 0 || b < 0)
			return false;
		
		if(a >= 1 && (!visited[a-1][b]) && board[a-1][b] == word.charAt(c)) {
			visited[a-1][b] = true;
			if(dfs(board, word, visited, a-1, b, c+1))
				return true;
			visited[a-1][b] = false;
		}
		
		if(a < board.length - 1 && (!visited[a+1][b]) && board[a+1][b] == word.charAt(c)) {
			visited[a+1][b] = true;
			if(dfs(board, word, visited, a+1, b, c+1))
				return true;
			visited[a+1][b] = false;
		}
		
		if(b >= 1 && (!visited[a][b-1]) && board[a][b-1] == word.charAt(c)) {
			visited[a][b-1] = true;
			if(dfs(board, word, visited, a, b-1, c+1))
				return true;
			visited[a][b-1] = false;
		}
		
		if(b < board[0].length - 1 && (!visited[a][b+1]) && board[a][b+1] == word.charAt(c)) {
			visited[a][b+1] = true;
			if(dfs(board, word, visited, a, b+1, c+1))
				return true;
			visited[a][b+1] = false;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'A','B','C','E'},
						{'S','F','C','S'},
						{'A','D','E','E'},};
		System.out.println(exist(board, "ABCCED"));
		System.out.println(exist(board, "SEE"));
		System.out.println(exist(board, "ABCB"));
	}

}
