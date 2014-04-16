package yunsheng.leetcode.practise;

public class ValidNumber {
	
	public boolean isNumber(String s) {
        if(s.trim().isEmpty())
            return false;  
        
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?"; 
        
        if(s.trim().matches(regex))  
            return true;  
        else
            return false;  
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
