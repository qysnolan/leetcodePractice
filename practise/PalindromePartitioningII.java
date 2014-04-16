package yunsheng.leetcode.practise;

public class PalindromePartitioningII {
	
	public static int minCut(String s) {
		if(s.length() <= 1)
			return 0;
		
		int len = s.length();
		boolean[][] table = new boolean[len][len];
		for(int i = len - 1; i >= 0; i--) {
			for(int j = i; j < len; j++) {
				if(s.charAt(i) == s.charAt(j) && (j - i < 2 || table[i+1][j-1]))
					table[i][j] = true;
				else
					table[i][j] = false;
			}
		}
		
		int[] cut = new int[len];
		int count = len;
		for(int i = 0; i < len; i++) {
			count = len;
			if(table[0][i])
				cut[i] = 0;
			else {
				for(int j = 1; j <= i; j++) 
					count = table[j][i] ? Math.min(count, cut[j-1] + 1) : count;
				cut[i] = count;
			}
		}
		
		return cut[len-1];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cabababcbc";
		System.out.print(minCut(s));
	}

}
