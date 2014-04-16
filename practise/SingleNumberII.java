package yunsheng.leetcode.practise;

public class SingleNumberII {
	
	public static int singleNumber(int[] A) {
		if(A.length == 0)
			return 0;
		
		int re = 0;
		int[] bit = new int[32];
		for(int i = 0; i < 32; i++) {
			for(Integer num : A) {
				bit[i] = num >> i & 1;
				bit[i] = bit[i]%3;
			}
			re = re | (bit[i]<<i);
		}
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4,4,1,2,2,4,1,3};
		System.out.println(singleNumber(A));
	}

}
