package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.HashSet;

//DFS cannot pass big data

public class WordLadderII {
	
	public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		ArrayList<ArrayList<String>> re = new ArrayList<ArrayList<String>>();
		ArrayList<String> cur = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		cur.add(start);
		set.add(start);
		findLaddersHelper(start, end, dict, re, cur, set);		
		return re;
    }
	
	private static void findLaddersHelper(String start, String end, HashSet<String> dict, 
			ArrayList<ArrayList<String>> re, ArrayList<String> cur, HashSet<String> set) {
		char[] str = start.toCharArray();
		for(int i = 0; i < start.length(); i++) {			
			char t = str[i];
			for(char c = 'a'; c <= 'z'; c++) {
				if(t == c)
					continue;
				str[i] = c;
				String s = new String(str);
				if(s.equals(end)) {
					cur.add(s);
					ArrayList<String> tmp = new ArrayList<String>(cur);
					if(re.isEmpty())
						re.add(tmp);
					if(tmp.size() < re.get(0).size()) {
						re.clear();
						re.add(tmp);
					}
					else if(tmp.size() == re.get(0).size())
						re.add(tmp);
					cur.remove(cur.size()-1);
				}	
				if(dict.contains(s) && !set.contains(s)) {
					cur.add(s);
					set.add(s);
					if(re.isEmpty() || re.get(0).size() >= set.size() - 1)
						findLaddersHelper(s, end, dict, re, cur, set);
					cur.remove(cur.size()-1);
					set.remove(s);
				}
			}
			str[i] = t;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(findLadders(start, end, dict));
	}

}
