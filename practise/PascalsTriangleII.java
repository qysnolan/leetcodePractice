package yunsheng.leetcode.practise;

import java.util.ArrayList;

public class PascalsTriangleII {
	
	public static ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> re = new ArrayList<Integer>();
		if(rowIndex < 0)
			return re;
		
		re.add(1);
		for(int i = 2; i <= rowIndex + 1; i++) {
			int pre = 1;
			for(int j = 1; j < i-1; j++) {
				int cur = re.get(j);
				re.set(j, pre + cur);
				pre = cur;
			}
			re.add(1);
		}
		
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRow(3));

	}

}
