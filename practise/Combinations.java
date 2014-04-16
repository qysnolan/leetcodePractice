package yunsheng.leetcode.practise;

import java.util.ArrayList;

public class Combinations {
	
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
		if(n < k || n <= 0 || k <= 0)
			return re;
		ArrayList<Integer> cur = new ArrayList<Integer>();
		combineHelper(n, k, 1, re, cur);
		return re;		
	}
	
	private static void combineHelper(int n, int k, int level, 
			ArrayList<ArrayList<Integer>> re, ArrayList<Integer> cur) {
		if(cur.size() == k) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(cur);
			re.add(tmp);
			return;
		}
		
		if(level > n)
			return;
		
		for(int i = level; i <= n; i++) {
			cur.add(i);
			combineHelper(n, k, i+1, re, cur);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combine(4,2));
	}

}
