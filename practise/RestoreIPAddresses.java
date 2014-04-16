package yunsheng.leetcode.practise;

import java.util.ArrayList;

public class RestoreIPAddresses {
	
	public static ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> re = new ArrayList<String>();
		if(s.length() > 12)
			return re;
		restoreIpAddressesHelper(s, 0, "", re);
		return re;
	}
	
	private static void restoreIpAddressesHelper(String s, int level, 
			String tmp, ArrayList<String> re) {
		if(level == 3 && isValid(s)) {
			re.add(tmp + s);
			return ;
		}
		
		for(int i = 1; i <= 4 && i < s.length(); i++) {
			String str = s.substring(0, i);
			if(isValid(str))
				restoreIpAddressesHelper(s.substring(i), level + 1, 
						tmp + str + ".", re);
		}
		
	}
	
	private static boolean isValid(String s) {
		if(s.charAt(0) == '0')
			return s.equals("0");
		int num = Integer.parseInt(s);
		return num >= 0 && num <= 255;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(restoreIpAddresses("25525511135"));
	}

}
