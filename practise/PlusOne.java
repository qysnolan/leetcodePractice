package yunsheng.leetcode.practise;

public class PlusOne {
	
	public int[] plusOne(int[] digits) {
		
        if(digits.length == 0)
            return digits;
        
        int index = 0;
        while(index < digits.length) {
            if(digits[index] != 9)
                break;
            index++;
        }
        
        if(index == digits.length) {
            int[] re = new int[index + 1];
            re[0] = 1;
            return re;
        }
        
        int carry = 1;
        int num = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            num = (carry + digits[i])%10;
            carry = (carry + digits[i])/10;
            digits[i] = num;
            if(carry == 0)
                break;
        }
            
        return digits;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
