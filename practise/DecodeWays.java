package yunsheng.leetcode.practise;

//DFS, cannot pass big data
public class DecodeWays {
	
	public static int num;
	
	public static int numDecodings(String s) {
		if(s.length() == 0)
			return 0;
		num = 0;
		numDecodingsHelper(s, 0);
		return num;
	}
	
	private static void numDecodingsHelper(String s, int count) {
		if(s.length() == count) {
			num++;
			return;
		}
		numDecodingsHelper(s, count + 1);
		if(s.length() <= count + 1 || !isLetter(s, count))
			return;
		
		numDecodingsHelper(s, count + 2);		
	}
	
	private static boolean isLetter(String s, int a) {
		StringBuilder str = new StringBuilder();
		str.append(s.charAt(a));
		str.append(s.charAt(a+1));
		
		int c = Integer.parseInt(new String(str));
		if(c > 26 || c < 1)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("1258"));
	}

}
