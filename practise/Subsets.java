package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
		if(S.length == 0)
			return re;
		Arrays.sort(S);
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		subsetsHelper(S, re, tmp, 0);
		return re;
	}
	
	private static void subsetsHelper(int[] S, ArrayList<ArrayList<Integer>> re, 
			ArrayList<Integer> tmp, int level) {
		
		ArrayList<Integer> integers = new ArrayList<Integer>(tmp);
		re.add(integers);
		
		if(S.length == level)
			return ;
		
		for(int i = level; i < S.length; i++) {
			tmp.add(S[i]);
			subsetsHelper(S, re, tmp, i+1);
			tmp.remove(tmp.size()-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = {1,2,3};
		System.out.println(subsets(S));
	}

}
