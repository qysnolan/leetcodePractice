package yunsheng.leetcode.practise;

public class ClimbingStairs {
	
	public int climbStairs(int n) {
        int[] list = new int[n+1];
        return climbStairsHelper(n, list);
    }
	
	public int climbStairsHelper(int n, int[] list) {
        if(n <= 0) 
        	return 0;
        if(n <= 1) 
        	return 1;
        if(n == 2) 
        	return 2;
        if(list[n] != 0) 
        	return list[n];
        
        list[n] = climbStairsHelper(n-1, list) + climbStairsHelper(n-2, list);
        
        return list[n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
