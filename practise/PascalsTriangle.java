package yunsheng.leetcode.practise;

import java.util.ArrayList;

public class PascalsTriangle {
	
	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
		if(numRows <= 0)
			return re;
		ArrayList<Integer> pre = new ArrayList<Integer>();
		pre.add(1);
		re.add(pre);
		for(int i = 2; i <= numRows; i++) {
			ArrayList<Integer> cur = new ArrayList<Integer>();
			cur.add(1);
			for(int j = 1; j < i-1; j++) 
				cur.add(pre.get(j-1) + pre.get(j));			
			cur.add(1);
			re.add(cur);
			pre = cur;
		}
		
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generate(3));
	}

}
