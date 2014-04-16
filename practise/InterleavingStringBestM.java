package yunsheng.leetcode.practise;

public class InterleavingStringBestM {
	
	public static boolean isInterleave(String s1, String s2, String s3) {
		if(s1 == null || s2 == null || s3 == null)
			return false;
		if(s1.length() + s2.length() != s3.length())
			return false;
		
		boolean[][] match = new boolean[s1.length()+1][s2.length()+1];
		match[0][0] = true;
		for(int i1 = 1; i1 <= s1.length(); i1++) {
			if(s1.charAt(i1-1) == s3.charAt(i1-1))
				match[i1][0] = true;
			else
				break;
		}
		
		for(int i2 = 1; i2 <= s2.length(); i2++) {
			if(s2.charAt(i2-1) == s3.charAt(i2-1))
				match[0][i2] = true;
			else
				break;
		}
		
		for(int i1 = 1; i1 <= s1.length(); i1++) {
			char c1 = s1.charAt(i1 - 1);
			for(int i2 = 1; i2 <= s2.length(); i2++) {
				char c2 = s2.charAt(i2 - 1);
				char c3 = s3.charAt(i1 + i2 - 1);
				if(c1 == c3) 
					match[i1][i2] |= match[i1-1][i2];
				if(c2 == c3)
					match[i1][i2] |= match[i1][i2-1];
			}
		}
		
		return match[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		String s4 = "aadbbbaccc";
		System.out.println(isInterleave(s1,s2,s3));
		System.out.println(isInterleave(s1,s2,s4));
	}

}
