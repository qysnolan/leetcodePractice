package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {
	
	public ArrayList<String> anagrams(String[] strs) {
        HashMap<String,ArrayList<String>> records = new HashMap<String, ArrayList<String>>();
        ArrayList<String> output = new ArrayList<String>();
        for(int i = 0; i<strs.length;i++){
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String sorted = new String(charArr);
            if(records.containsKey(sorted))
                records.get(sorted).add(strs[i]);
            else{
                ArrayList<String> strings = new ArrayList<String>();
                strings.add(strs[i]);
                records.put(sorted, strings);
            }
        }
         
        for(ArrayList<String> currArr : records.values()){
            if(currArr.size()>1)
                output.addAll(currArr);
        }    
        return output;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
