package yunsheng.leetcode.practise;

public class MaximumSubarray {
	
	public int maxSubArray(int[] A) {
        if(A.length == 0)
            return 0;
        if(A.length == 1)
            return A[0];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(sum, max);
            sum = sum < 0 ? 0 : sum;
        }
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
