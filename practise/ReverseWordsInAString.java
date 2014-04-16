package yunsheng.leetcode.practise;

public class ReverseWordsInAString {
	
	public static String reverseWords(String s) {
		if(s == null || s.length() == 0)
            return s;
            
        String[] array = s.split(" ");
        StringBuilder result = new StringBuilder();
        int len = array.length;
        for(int i = len - 1; i >= 0; i--) {
            if(!array[i].equals("")) {
                result.append(array[i]);
                result.append(" ");
            }
        }
        
        if(result.length() > 0)
        	result.deleteCharAt(result.length()-1);
        
        return new String(result);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = " ";
		System.out.println(reverseWords(s));
	}

}
