package yunsheng.leetcode.practise;

public class DecodeWaysBestM {
	
	public static int numDecodings(String s) {
		if(s.length() == 0 || s.charAt(0) == '0')
			return 0;
		if(s.length() == 1)
			if(isLetter(s))
				return 1;
			else
				return 0;
		
		int[] count = new int[s.length() + 1];
		count[0] = 1;
		
		if(isLetter(s.substring(0, 1)))
			count[1] = 1;
		else
			count[1] = 0;
		
		for(int i = 2; i <= s.length(); i++) {
			if(isLetter(s.substring(i - 1, i)))
				count[i] = count[i - 1];
			if(isLetter(s.substring(i - 2, i)))
				count[i] += count[i - 2];
		}
		
		return count[s.length()];
	}
	
	private static boolean isLetter(String s) {
		if(s.charAt(0) == '0')
			return false;
		int c = Integer.parseInt(new String(s));
		return c <= 26 && c >= 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("101"));
	}

}
