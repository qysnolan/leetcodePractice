package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.HashSet;

public class PermutationsII {
	
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length == 0)
            return result;
        boolean[] visited = new boolean[num.length];
        HashSet<ArrayList<Integer>> duplicate = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        permuteUniqueHelper(num, result, visited, current, duplicate);
        return result;
    }
    
    public void permuteUniqueHelper(int[] num, ArrayList<ArrayList<Integer>> result, 
        boolean[] visited, ArrayList<Integer> current, HashSet<ArrayList<Integer>> duplicate) {
        if(current.size() == num.length) {
            if(!duplicate.contains(current)) {
                result.add(new ArrayList<Integer>(current));
                duplicate.add(current);
            }
            return ;
        }
        for(int i = 0; i < num.length; i++) {
            if(!visited[i]) {
                current.add(num[i]);
                visited[i] = true;
                permuteUniqueHelper(num, result, visited, current, duplicate);
                visited[i] = false;
                current.remove(current.size()-1);
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
