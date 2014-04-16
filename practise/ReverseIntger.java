package yunsheng.leetcode.practise;

public class ReverseIntger {
	
	public int reverse(int x) {
        int result = 0;
        boolean isNeg = x > 0 ? false : true;
        x = Math.abs(x);
    
        while(x > 0) {
            result = result*10 + x%10;
            x = x/10;
        }
    
        if(result<0) return -1;
    
        if(isNeg)
            result *= -1;
    
        return result;     
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
