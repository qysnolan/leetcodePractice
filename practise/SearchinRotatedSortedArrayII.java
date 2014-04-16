package yunsheng.leetcode.practise;

//Same complexity as linear search
public class SearchinRotatedSortedArrayII {
	
	public boolean search(int[] A, int target) {
        if(A.length <= 0)
            return false;
            
        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        
        while(start <= end) {
            mid = (start + end)/2;
            if(A[mid] == target)
                return true;
            if(A[mid] > A[start]) {
                if(A[mid] > target && A[start] <= target)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else if(A[mid] < A[start]) {
                if(A[mid] < target && A[end] >= target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            else
                start++;
        }
        
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
