package yunsheng.leetcode.practise;

import java.util.ArrayList;

public class StringtoInteger {
	
	public int atoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
        int index = 0;
        ArrayList<Integer> array = new ArrayList<Integer>();
        
        while (str.charAt(index) == ' ') 
            index++;
            
        if(!(isNum(str, index) || str.charAt(index)=='+' || str.charAt(index)=='-'))
            return 0;
            
        int sign = 1;
        if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        else if(str.charAt(index) == '+')
            index++;
        
        while (str.length() > index && isNum(str, index)) {
            array.add((int)str.charAt(index)-'0');
            index++;
        }
        
        double re = 0;
        for (int i = 0; i < array.size(); i++) 
            re += array.get(i)*Math.pow(10, array.size()-i-1);
        
        if((sign < 0 && re*sign < (double)Integer.MIN_VALUE))
            return Integer.MIN_VALUE;
        else if ((sign > 0) && re > (double)Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        
        if(sign<0) 
            if(re*sign < (double)Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else
                return (int)(re*sign);
        else 
            if(re > (double)Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else
                return (int)re;
    }
    
    public boolean isNum(String str, int index){
        int asc = (int)str.charAt(index);
        return asc >= '0' && asc <= '9' ? true : false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
