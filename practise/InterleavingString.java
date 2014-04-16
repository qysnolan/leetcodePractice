package yunsheng.leetcode.practise;

//DFS cannot pass big data
public class InterleavingString {
	
	public static boolean isInterleave(String s1, String s2, String s3) {
		if(s1 == null || s2 == null || s3 == null)
			return false;
		if(s1.length() + s2.length() != s3.length())
			return false;
		return isInterleaveHelper(s1, s2, s3, 0, 0, 0);
	}
	
	private static boolean isInterleaveHelper(String s1, String s2, String s3, int p1, int p2, int p3) {
		if(p1 > s1.length() || p2 > s2.length() || p3 > s3.length())
			return false;
		if((p1 == s1.length() || p2 == s2.length()) && p3 == s3.length())
			return true;
		
		if(p1 == s1.length()) {
			if(s2.charAt(p2) == s3.charAt(p3))
				return isInterleaveHelper(s1, s2, s3, p1, p2+1, p3+1);
			else
				return false;
		}
		
		if(p2 == s2.length()) {
			if(s1.charAt(p1) == s3.charAt(p3))
				return isInterleaveHelper(s1, s2, s3, p1+1, p2, p3+1);
			else
				return false;
		}
		
		if(s1.charAt(p1) == s3.charAt(p3) && s2.charAt(p2) == s3.charAt(p3))
			return isInterleaveHelper(s1, s2, s3, p1+1, p2, p3+1) 
					|| isInterleaveHelper(s1, s2, s3, p1, p2+1, p3+1);
		if(s1.charAt(p1) == s3.charAt(p3))
			return isInterleaveHelper(s1, s2, s3, p1+1, p2, p3+1);
		if(s2.charAt(p2) == s3.charAt(p3))
			return isInterleaveHelper(s1, s2, s3, p1, p2+1, p3+1);
		
		return false;
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
