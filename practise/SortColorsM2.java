package yunsheng.leetcode.practise;

import java.util.Arrays;

public class SortColorsM2 {
	
	public static void sortColors(int[] A) {
		if(A.length <= 0)
			return;
		
        int i = 0, j = A.length - 1;    

        while(i < A.length && A[i]==0) 
        	i++;
        
        int cur=i;
        
        while(j >= 0 && A[j] == 2) 
        	j--;
        
        while(cur <= j){
            if(A[cur] <= A[i]){
                swap(A, i, cur);               
                while(i < A.length && A[i] == 0){
                    i++;
                    cur = i;
                }
            }
            if(cur <= j && A[cur] > A[j]){
                swap(A, cur, j);
                while(j >= 0 && A[j] == 2)
                	j--;
            }
            else
                cur++;
        }
    }
	
	private static void swap(int[] num, int a, int b){
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,1,0,0,2};
		System.out.println(Arrays.toString(a));
		sortColors(a);
		System.out.println(Arrays.toString(a));
	}

}
