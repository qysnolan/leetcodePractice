package yunsheng.leetcode.practise;

import java.util.ArrayList;

public class PalindromePartitioning {
	
	public static ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> re  = new ArrayList<ArrayList<String>>();
		if(s.length() == 0)
			return re;
		ArrayList<String> cur = new ArrayList<String>();
		partitionHelper(s, re, cur, 0);
		return re;
	}
	
	private static void partitionHelper(String s, ArrayList<ArrayList<String>> re, 
			ArrayList<String> cur, int start) {
		if(start == s.length()) {
			ArrayList<String> tmp = new ArrayList<String>(cur);
			re.add(tmp);
			return;
		}
		for(int i = start; i < s.length(); i++) {
			if(isPalindrome(s.substring(start, i+1))) {
				cur.add(s.substring(start, i+1));
				partitionHelper(s, re, cur, i+1);
				cur.remove(cur.size()-1);
			}
		}
	}
	
	private static boolean isPalindrome(String s) {
		if(s.length() <= 1)
			return true;
		int front = 0;
		int rear = s.length() - 1;
		while(front < rear) {
			if(s.charAt(front) != s.charAt(rear))
				return false;
			front++;
			rear--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		System.out.print(partition(s));
	}

}
