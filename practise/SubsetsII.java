package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SubsetsII {
	
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
		
		if(num.length == 0)
			return re;
		
		Arrays.sort(num);
		HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		
		subsetsHelper(num, res, tmp, 0);
		
		for(ArrayList<Integer> l : res)
			re.add(l);
		
		return re;
	}
	
	private static void subsetsHelper(int[] num, HashSet<ArrayList<Integer>> re, 
			ArrayList<Integer> tmp, int level) {
		
		ArrayList<Integer> integers = new ArrayList<Integer>(tmp);
		re.add(integers);
		
		if(num.length == level)
			return ;
		
		for(int i = level; i < num.length; i++) {
			tmp.add(num[i]);
			subsetsHelper(num, re, tmp, i+1);
			tmp.remove(tmp.size()-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = {1,2,2};
		System.out.println(subsetsWithDup(S));
	}

}
