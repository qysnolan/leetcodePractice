package yunsheng.leetcode.practise;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {
	
	public static int removeDuplicates(int[] A) {
		if(A.length <= 1)
			return A.length;
		
		int cur = 0;
		int runner = 0;
		while(runner + 1< A.length) {
			if(A[runner] == A[runner + 1])
				runner++;
			else {
				A[cur + 1] = A[runner + 1];
				cur++;
				runner++;
			}
		}
		
		return cur + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2};
		System.out.println(Arrays.toString(a));
		System.out.println(removeDuplicates(a));
		System.out.println(Arrays.toString(a));
	}

}
