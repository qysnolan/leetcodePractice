package yunsheng.leetcode.practise;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	
	public static int evalRPN(String[] tokens) {
		if(tokens == null || tokens.length == 0)
            return 0;
        if(tokens.length == 1)
            return Integer.parseInt(tokens[0]);
        
        Stack<Integer> s = new Stack<Integer>();
        String operators = "+-*/";
        for(int i = 0; i < tokens.length; i++) {
        	if(!operators.contains(tokens[i]))
        		s.push(Integer.parseInt(tokens[i]));
        	else {
        		int b = s.pop();
        		int a = s.pop();
        		switch(operators.indexOf(tokens[i])) {
	        		case 0:
	        			s.push(a + b);
	        			break;
	        		case 1:
	        			s.push(a - b);
	        			break;
	        		case 2:
	        			s.push(a * b);
	        			break;
	        		case 3:
	        			s.push(a / b);
	        			break;
        		}
        	}
        }
               
        return s.pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(tokens));
	}

}
