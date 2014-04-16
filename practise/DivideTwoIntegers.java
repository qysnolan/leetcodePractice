package yunsheng.leetcode.practise;

public class DivideTwoIntegers {
	
	public int divide(int dividend, int divisor) {
        if(dividend == 0)
            return 0;
        if(divisor == 1)
            return dividend;
        if(divisor == -1)
            return -dividend;
        if(divisor == dividend)
            return 1;
        if(divisor == -dividend)
            return -1;
        if(divisor == 2)
            return dividend >> 1;
            
        if(dividend == Integer.MAX_VALUE && divisor == Integer.MIN_VALUE)
            return 0;
        
        boolean sign = false;
        if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            sign = true;
        
        dividend = dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(dividend);
        divisor = divisor == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(divisor);
        int re = (int)Math.floor(Math.pow(Math.E, Math.log(dividend) - Math.log(divisor)));
        return sign ? re : -re;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
