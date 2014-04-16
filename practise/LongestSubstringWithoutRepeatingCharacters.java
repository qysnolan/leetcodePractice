package yunsheng.leetcode.practise;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;
        
        int re = 0;
        HashMap<Character, Integer> table = new HashMap<Character, Integer>();
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!table.containsKey(c)) {
                table.put(c, i);
            }
            else {
                int index = table.get(c);
                re = Math.max(table.size(), re);
                for(int j = start; j <= index; j++) 
                    table.remove(s.charAt(j));
                start = index + 1;
                table.put(c, i);
            }
        }
        re = Math.max(table.size(), re);
        return re;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
