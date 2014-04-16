package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GenerateParentheses {
	
	public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String> ();
        if(n<=0) return result;
        Set<String> s = generateParenthesisHelper(n);
        for (String str : s) 
            result.add(str);
        return result;
    }
    public Set<String> generateParenthesisHelper(int remaining) {
        Set<String> set = new HashSet<String> ();
        if(remaining==0) {
            set.add("");
        }
        else {
            Set<String> temp = generateParenthesisHelper(remaining - 1);
            for(String str : temp) {
                for(int i=0; i<str.length(); i++) {
                    if(str.charAt(i) == '(') {
                        String s = addInside(str, i);
                        set.add(s);
                    }
                }
                set.add("()" + str);
            }
        }
        return set;
    }
    public String addInside(String s, int index) {
        String left = s.substring(0, index+1);
        String right = s.substring(index+1, s.length());
        return left + "()" + right;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
