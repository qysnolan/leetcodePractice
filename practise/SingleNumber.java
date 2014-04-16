package yunsheng.leetcode.practise;

public class SingleNumber {
	
	public static int singleNumber(int[] A) {
		int re = 0;
		for(Integer i : A) 
			re = re^i;
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4,4,1,2};
		System.out.println(singleNumber(A));
	}

}
