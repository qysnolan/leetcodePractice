package yunsheng.leetcode.practise;

public class LongestPalindromicSubstring {
	
	public String longestPalindrome(String s) {
        if(s == null)
            return null;
        if(s.length() <= 1)
            return s;
            
        String longest = "";
        for(int i = 0; i < s.length(); i++) {
            String tmp = longest(s, i, i);
            if(longest.length() < tmp.length()) 
                longest = tmp;
            tmp = longest(s, i, i+1);
            if(longest.length() < tmp.length()) 
                longest = tmp;
        }
        return longest;
    }
    
    public String longest(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
