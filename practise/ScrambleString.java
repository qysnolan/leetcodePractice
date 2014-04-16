package yunsheng.leetcode.practise;

import java.util.Arrays;

public class ScrambleString {
	
	public static boolean isScramble(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		if(s1.length() == 1)
			return s1.charAt(0) == s2.charAt(0);
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if(!new String(c1).equals(new String(c2)))
			return false;
		
		for(int i = 1; i < s1.length(); i++) {
			String s11 = s1.substring(0,i);
			String s12 = s1.substring(i);
			String s21 = s2.substring(0,i);
			String s22 = s2.substring(i);
			if(isScramble(s11, s21) && isScramble(s12, s22))
				return true;
			s21 = s2.substring(0, s2.length() - i);
			s22 = s2.substring(s2.length() - i);
			if(isScramble(s11, s22) && isScramble(s12, s21))
				return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isScramble("ab","ba"));
	}

}
