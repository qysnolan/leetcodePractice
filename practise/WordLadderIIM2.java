package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//BFS cannot pass big data

public class WordLadderIIM2 {
	
	public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		ArrayList<ArrayList<String>> re = new ArrayList<ArrayList<String>>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		ArrayList<String> list = new ArrayList<String>();
		list.add(start);
		map.put(start, list);
		HashSet<ArrayList<String>> set = new HashSet<ArrayList<String>>();
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		
		boolean found = false;
		
		while(!queue.isEmpty()) {
			char[] cur = queue.poll().toCharArray();
			String pre = new String(cur);
			for(int i = 0; i < cur.length; i++) {
				char t = cur[i];
				for(char c = 'a'; c <= 'z'; c++) {
					if(c == t)
						continue;
					cur[i] = c;
					String str = new String(cur);
					if(str.equals(end)) {
						ArrayList<String> add = new ArrayList<String>(map.get(pre));
						add.add(end);
						if(!set.contains(add)) {
							if(re.isEmpty()) {
								re.add(add);
								found = true;
							}
							else if(re.get(0).size() == add.size()) {
								re.add(add);
							}
							set.add(add);
						}
					}
					if(!found && dict.contains(str)) {
						ArrayList<String> add = new ArrayList<String>(map.get(pre));
						add.add(str);
						if(!map.containsKey(str))
							map.put(str, add);
						queue.add(str);
					}
				}
				cur[i] = t;
			}
			
		}
		
		return re;
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
