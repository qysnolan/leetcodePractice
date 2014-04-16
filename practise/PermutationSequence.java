package yunsheng.leetcode.practise;

import java.util.ArrayList;

public class PermutationSequence {
	
	public String getPermutation(int n, int k) {
        StringBuilder builder = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++)
            num.add(i);
        int[] fac = getFac(n);
        k--;
        for(int i = 0; i < n; i++) {
            int index = k/fac[n - 1 - i];
            k = k%fac[n - 1 - i];
            builder.append(num.get(index));
            num.remove(index);
        }
        return builder.toString();
    }
    
    public int[] getFac(int n) {
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            if(i == 0)
                result[i] = 1;
            else
                result[i] = result[i-1]*i;
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
