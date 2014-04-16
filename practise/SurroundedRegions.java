package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;

public class SurroundedRegions {

	public static void solve(char[][] board) {
		if(board.length <= 2 || board[0].length <= 2)
			return;
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for(int i = 0; i < m; i++) {
			visited[i][0] = true;
			if(board[i][0] == 'O') 
				bfs(i, 0, board, visited);
			visited[i][n-1] = true;
			if(board[i][n-1] == 'O') 
				bfs(i, n-1, board, visited);
		}
		for(int j = 0; j < n; j++) {
			visited[0][j] = true;
			if(board[0][j] == 'O') 
				bfs(0, j, board, visited);
			visited[m-1][j] = true;
			if(board[m-1][j] == 'O') 
				bfs(m-1, j, board, visited);
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j] || board[i][j] == 'X')
					continue;
				board[i][j] = 'X';
			}
		}
	}
	
	private static void bfs(int i, int j, char[][] board, boolean[][] visited) {
		ArrayList<Integer> q1 = new ArrayList<Integer>();
		ArrayList<Integer> q2 = new ArrayList<Integer>();
		q1.add(i);
		q2.add(j);
		int m = board.length;
		int n = board[0].length;
		while(!q1.isEmpty()) {
			int a = q1.remove(0);
			int b = q2.remove(0);
			if(a - 1 > 0 && !visited[a-1][b]) {
				visited[a-1][b] = true;
				if(board[a-1][b] == 'O') {
					q1.add(a-1);
					q2.add(b);
				}
			}
			if(a + 1 < m && !visited[a+1][b]) {
				visited[a+1][b] = true;
				if(board[a+1][b] == 'O') {
					q1.add(a+1);
					q2.add(b);
				}
			}
			if(b - 1 > 0 && !visited[a][b-1]) {
				visited[a][b-1] = true;
				if(board[a][b-1] == 'O') {
					q1.add(a);
					q2.add(b-1);
				}
			}
			if(b + 1 < n && !visited[a][b+1]) {
				visited[a][b+1] = true;
				if(board[a][b+1] == 'O') {
					q1.add(a);
					q2.add(b+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] c = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
		System.out.println(Arrays.deepToString(c));
		solve(c);
		System.out.println(Arrays.deepToString(c));
	}

}
