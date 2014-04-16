package yunsheng.leetcode.practise;

import java.util.ArrayList;

public class RomantoInteger {
	
	public int romanToInt(String s) {
        ArrayList<Character> oneletter = new ArrayList<Character> ();
        oneletter.add('I');
        oneletter.add('X');
        oneletter.add('C');
        oneletter.add('M');
        ArrayList<Character> fiveletter = new ArrayList<Character> ();
        fiveletter.add('V');
        fiveletter.add('L');
        fiveletter.add('D');
        int num = 0;
        for(int i=0; i<s.length(); i++) {
            int bit = fiveletter.indexOf(s.charAt(i));
            if(bit!=-1) num += 5*(int)Math.pow(10, bit);
            else {
                bit = oneletter.indexOf(s.charAt(i));
                if(i+1<s.length()
                &&(bit<oneletter.indexOf(s.charAt(i+1))
                ||bit<=fiveletter.indexOf(s.charAt(i+1))))
                    num -= (int)Math.pow(10, bit);
                else 
                    num += (int)Math.pow(10, bit);
            }
        }
        return num;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
