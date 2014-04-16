package yunsheng.leetcode.practise;

public class LengthofLastWord {
	
	public int lengthOfLastWord(String s) {
        if(s == null)
            return 0;
        
        int n = s.length();
        if(n == 0)
            return 0;
        
        int index = n - 1;  
        while(index >= 0) {
            if(s.charAt(index) != ' ')
                break;
            index--;
        }
        if(index < 0)
            return 0;
        int count = 0;
        while(index >= 0) {
            if(s.charAt(index) == ' ')
                break;
            count++;
            index--;
        }
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
