package yunsheng.leetcode.practise;

public class UniqueBinarySearchTrees {
	
	public static int numTrees(int n) {
		if(n <= 0)
			return 0;
		
		int[] table = new int[n+1];
		
		table[0] = 1;
		for(int i = 1; i <= n; i++)
			for(int j = 0; j <= i-1; j++)
				table[i] += table[j]*table[i-j-1];
		
		return table[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(3));
	}

}
