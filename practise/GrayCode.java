package yunsheng.leetcode.practise;

import java.util.ArrayList;

public class GrayCode {
	
	public static ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> re = new ArrayList<Integer>();
		if(n == 0) {
			re.add(0);
			return re;
		}
		
		ArrayList<Integer> pre = grayCode(n - 1);
		re.addAll(pre);
		
		for(int j = pre.size() - 1; j >= 0; j--) 
			re.add(pre.get(j) + (int)Math.pow(2, n - 1));
		
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(grayCode(3));
	}

}
