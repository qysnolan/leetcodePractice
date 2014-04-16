package yunsheng.leetcode.practise;

import java.util.ArrayList;

public class LetterCombinationsofaPhoneNumber {
	
	public ArrayList<String> letterCombinations(String digits) {
        if(digits == null)
            return null;
        String[] letter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Character> tmp = new ArrayList<Character>(); 
        letterHelper(digits, result, tmp, letter, 0);
        return result;
    }
    public void letterHelper(String digits, ArrayList<String> result, 
                             ArrayList<Character> tmp, String[] letter, int level) {
        if(level == digits.length()) {
            StringBuilder builder = new StringBuilder(tmp.size());
            for(Character ch: tmp)
                builder.append(ch);
            if(tmp.size() == digits.length())
                result.add(builder.toString());
            return ;
        }
        for(int i = level; i < digits.length(); i++) {
            String currentLetter  = letter[(int)digits.charAt(i)-48];
            for(int j = 0; j < currentLetter.length(); j++) {
                tmp.add(currentLetter.charAt(j));
                letterHelper(digits, result, tmp, letter, i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
