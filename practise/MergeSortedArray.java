package yunsheng.leetcode.practise;

import java.util.Arrays;

public class MergeSortedArray {
	
	public static void merge(int A[], int m, int B[], int n) {
		int index = m + n - 1;
		int i = m - 1;
		int j = n - 1;
		
		while(j >= 0) {
			if(i < 0 || B[j] > A[i]) 
				A[index--] = B[j--];
			else
				A[index--] = A[i--];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,5,0,0,0};
		int[] B = {-1,0,2};
		merge(A,3,B,3);
		System.out.println(Arrays.toString(A));
	}

}
