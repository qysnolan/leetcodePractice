package yunsheng.leetcode.practise;

public class ImplementstrStr {
	
	public String strStr(String haystack, String needle) {
        if(haystack == null) 
        	return null;
        if(needle == null) 
        	return haystack;
        if(haystack.length() < needle.length()) 
        	return null;
        
        int len = haystack.length() - needle.length() + 1;
        for(int i=0; i<len; i++) {
            if(haystack.substring(i).startsWith(needle))
                return haystack.substring(i);
        }
        return null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
