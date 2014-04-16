package yunsheng.leetcode.practise;

import java.util.HashSet;

public class LongestConsecutiveSequence {
	
	public static int longestConsecutive(int[] num) {
		if(num.length <= 1)
			return num.length;
		HashSet<Integer> set = new HashSet<Integer>();
		for(Integer i : num) 
			set.add(i);
		int max = 0;
		for(Integer e : num) {
			int count = 1;
			int i = e - 1;
			int j = e + 1;
			while(set.contains(i)) {
				count++;
				set.remove(i);
				i--;
			}
			while(set.contains(j)) {
				count++;
				set.remove(j);
				j++;
			}
			max = Math.max(count, max);				
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(num));
	}

}
