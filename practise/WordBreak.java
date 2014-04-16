package yunsheng.leetcode.practise;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
	public static boolean wordBreak(String s, Set<String> dict) {
		boolean[] table = new boolean[s.length() + 1];
		table[0] = true;
		
		for(int i = 0; i < s.length(); i++) {
			if(!table[i])
				continue;
			
			for(String str : dict) {
				int len = str.length();
				int end = len + i;
				
				if(end > s.length())
					continue;
				if(table[end])
					continue;
				if(s.substring(i, end).equals(str))
					table[end] = true;
			}
		}
		
		return table[s.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		System.out.print(wordBreak(s, dict));
	}

}
