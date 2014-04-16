package yunsheng.leetcode.practise;

import java.util.ArrayList;

public class Permutations {
	
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
            return result;
        ArrayList<Integer> current = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        permuteHelper(num, result, current, visited);
        return result;
    }
    
    public void permuteHelper(int[] num, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, boolean[] visited) {
        if(current.size() == num.length) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(current);
            result.add(tmp);
            return ;
        }
        for(int i = 0; i < num.length; i++) {
            if(!visited[i]) {
                current.add(num[i]);
                visited[i] = true;
                permuteHelper(num, result, current, visited);
                current.remove(current.size()-1);
                visited[i] = false;
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
