package yunsheng.leetcode.practise;

import java.util.HashMap;

public class TwoSum {
	
	public int[] twoSum(int[] numbers, int target) {
        int[] output = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();
        for(int i=0; i<numbers.length; i++) 
            map.put(numbers[i], i);
        for(int i=0; i<numbers.length; i++) {
            int val = target-numbers[i];
            if(map.containsKey(val)) {
                int index = map.get(val);
                if(index<i) {
                    output[0] = index + 1;
                    output[1] = i + 1;
                    return output;
                }
                else if(index>i) {
                    output[1] = index + 1;
                    output[0] = i + 1;
                    return output;
                }
            }
        }
        return output;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
