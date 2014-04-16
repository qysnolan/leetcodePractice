package yunsheng.leetcode.practise;

import java.util.Stack;

public class ValidParentheses {
	
	public boolean isValid(String s) {
        if(s==null || s.length()<=1)
            return false;
        Stack<Character> sta = new Stack<Character> ();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='[') {
                sta.push(c);
                continue;
            }
            if(c==')' || c=='}' || c==']') {
                if(sta.size()==0)
                    return false;
                char f = sta.pop();
                if((c==')' && f!='(') || (c=='}' && f!='{') || (c==']' && f!='['))
                    return false;
            }
        }
        if(sta.size()>0)
            return false;
        else
            return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
