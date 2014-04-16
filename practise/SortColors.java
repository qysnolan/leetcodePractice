package yunsheng.leetcode.practise;

import java.util.Arrays;

public class SortColors {
	
	public static void sortColors(int[] A) {
        if(A.length <= 1)
            return;
            
        int[] count = new int[3];
        for(Integer i : A)
            count[i]++;
            
        int index = 0;
        for(int i = 0; i < count.length; i++) {
            while(count[i] > 0) {
                A[index++] = i;
                count[i]--;
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,1,0};
		System.out.println(Arrays.toString(a));
		sortColors(a);
		System.out.println(Arrays.toString(a));
	}

}
