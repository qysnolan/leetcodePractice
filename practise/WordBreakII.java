package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreakII {
	
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();		
		return wordBreakHelper(s, dict, map);
	}
	
	private static ArrayList<String> wordBreakHelper(String s, Set<String> dict, HashMap<String, ArrayList<String>> map) {
		if(map.containsKey(s))
			return map.get(s);
		
		ArrayList<String> re = new ArrayList<String>();
		int len = s.length();
		if(len == 0)
			return re;
		
		for(int i = 0; i <= len; i++) {
			String pre = s.substring(0, i);
			if(dict.contains(pre)) {
				if(len == i)
					re.add(pre);
				else {
					ArrayList<String> tmp = wordBreakHelper(s.substring(i), dict, map);
					for(String str : tmp) {
						str = pre + " " + str;
						re.add(str);
					}
				}
			}
		}
		
		map.put(s, re);
		return re;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		System.out.println(wordBreak(s, dict));
	}

}
