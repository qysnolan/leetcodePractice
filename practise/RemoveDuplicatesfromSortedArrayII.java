package yunsheng.leetcode.practise;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayII {
	
	public static int removeDuplicates(int[] A) {
		if(A.length <= 2)
			return A.length;
		
		int cur = 0;
		int runner = 0;
		int count = 0;
		
		while(runner + 1 < A.length) {
			if(A[runner] == A[runner + 1] && count == 0) {
				A[cur + 1] = A[runner + 1];
				cur++;
				runner++;
				count++;
			}
			else if(A[runner] == A[runner + 1]) {
				runner++;
				count++;
			}
			else {
				A[cur + 1] = A[runner + 1];
				cur++;
				runner++;
				count = 0;
			}
		}
		
		return cur + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,1,1,1,3,3};
		System.out.println(Arrays.toString(a));
		System.out.println(removeDuplicates(a));
		System.out.println(Arrays.toString(a));
	}

}
