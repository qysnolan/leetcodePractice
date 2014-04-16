package yunsheng.leetcode.practise;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {
	
	public static int ladderLength(String start, String end, HashSet<String> dict) {
		HashSet<String> set = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		set.add(start);
		queue.offer(start);
		int count = 1;
		int distance = 1;
		
		while(count > 0) {
			while(count > 0) {
				char[] str = queue.poll().toCharArray();
				for(int i = 0; i < str.length; i++) {
					char t = str[i];
					for(char c = 'a'; c <= 'z'; c++) {
						if(c == t)
							continue;
						str[i] = c;
						String tmp = new String(str);
						if(tmp.equals(end))
							return distance + 1;
						if(dict.contains(tmp) && !set.contains(tmp)) {
							queue.offer(tmp);
							set.add(tmp);
						}
					}
					str[i] = t;
				}				
				count--;
			}
			
			distance++;
			count = queue.size();
		}	
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "hit";
		String end = "hht";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(ladderLength(start, end, dict));
	}

}
