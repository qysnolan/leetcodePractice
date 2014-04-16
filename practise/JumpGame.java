package yunsheng.leetcode.practise;

public class JumpGame {
	
	public boolean canJump(int[] A) {
        int n = A.length;
        int reach = 1;
        for (int i = 0; i < reach && reach < n; i++)
            reach = Math.max(reach, A[i] + i + 1);
        return reach >= n;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
