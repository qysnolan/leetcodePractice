package yunsheng.leetcode.practise;

public class CountandSay {
	
	public String countAndSay(int n) {
        if(n == 1)
            return "1";
          
        String s = "1";  
        StringBuffer ret = new StringBuffer();  
        int cnt = 0;  
        int round = 1;  
        int i;  
        while(round < n){  
            cnt = 1;  
            ret.setLength(0);  
            for(i = 1; i < s.length(); i++){  
                if(s.charAt(i) == s.charAt(i-1))  
                    cnt++;  
                else {   
                    ret.append(cnt).append(s.charAt(i-1));  
                    cnt = 1; 
                }  
            }  
            ret.append(cnt).append(s.charAt(i-1));  
            s = ret.toString(); 
            round++;
        }  
        return ret.toString(); 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
