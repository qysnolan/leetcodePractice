package yunsheng.leetcode.practise;

public class SearchInsertPosition {
	
	public int searchInsert(int[] A, int target) {
        if(A.length == 0)
            return 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] >= target)
                return i;
        }
        return A.length;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
