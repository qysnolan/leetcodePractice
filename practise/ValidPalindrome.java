package yunsheng.leetcode.practise;

public class ValidPalindrome {
	
	public static boolean isPalindrome(String s) {
		int len = s.length();
		if(len <= 1)
			return true;
		
		int i = 0;
		int j = len - 1;
		while(i < j) {
			while(i < len && !isLetter(s.charAt(i)))
				i++;
			while(j > 0 && !isLetter(s.charAt(j)))
				j--;
			if(i > j)
				return true;
			if(!isEqual(s.charAt(i), s.charAt(j)))
				return false;
			i++;
			j--;
		}		
		
		return true;
	}
	
	private static boolean isLetter(char c) {
		if((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A') || (c <= '9' && c >= '0'))
			return true;
		else
			return false;
	}
	
	private static boolean isEqual(char a, char b) {
		char i = Character.toLowerCase(a);
		char j = Character.toLowerCase(b);
		return i == j ? true : false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "A man, a plan, a canal: Panama";
		String b = "1a2";
		System.out.println(isPalindrome(a));
		System.out.println(isPalindrome(b));
	}

}
