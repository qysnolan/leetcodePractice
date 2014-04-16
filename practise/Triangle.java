package yunsheng.leetcode.practise;

import java.util.ArrayList;

public class Triangle {
	
	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {	
		if(triangle.size() == 0)
			return 0;
		
		ArrayList<Integer> list = new ArrayList<Integer>(triangle.get(triangle.size()-1));
		for(int i = triangle.size() - 2; i >= 0; i--) {
			ArrayList<Integer> cur = triangle.get(i);
			for(int j = 0; j < cur.size(); j++) 
				list.set(j, Math.min(list.get(j), list.get(j+1)) + cur.get(j));
		}
		
		return list.get(0);		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		ArrayList<Integer> l4 = new ArrayList<Integer>();
		
		l1.add(2);
		l2.add(3);
		l2.add(4);
		l3.add(6);
		l3.add(5);
		l3.add(7);
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		
		ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
		l.add(l1);
		l.add(l2);
		l.add(l3);
		l.add(l4);
		
		System.out.println(minimumTotal(l));
	}

}
