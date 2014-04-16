package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class FourSum {

	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        int n = num.length;
        if(n < 4)
            return re;
        //two sum table and hash table
        int[][] twoSum = new int[n][n];
        HashMap<Integer, ArrayList<Integer>> table = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int sum = num[i] + num[j];
                twoSum[i][j] = sum;
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                if(table.containsKey(sum))
                    tmp = table.get(sum);
                tmp.add(i);
                tmp.add(j);
                table.put(sum, tmp);
            }
        }
        //found the sum of two sum is target
        HashSet<ArrayList<Integer>> check = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int t = target - twoSum[i][j];
                if(table.containsKey(t)) {
                    ArrayList<Integer> tmp = table.get(t);
                    for(int k = 0; k < tmp.size() - 1; k += 2) {  
                    	ArrayList<Integer> oneRe = new ArrayList<Integer>();
                        oneRe.add(num[i]);
                        oneRe.add(num[j]);
                        oneRe.add(num[tmp.get(k)]);
                        oneRe.add(num[tmp.get(k+1)]);
                        Collections.sort(oneRe);
                    	if(!check.contains(oneRe) && tmp.get(k) != j && tmp.get(k+1) != i 
                    			&& tmp.get(k) != i && tmp.get(k+1) != j) {
                    		check.add(oneRe);                            
                            re.add(oneRe);
                        }
                    }
                }
            }
        }
        return re;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
