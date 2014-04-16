package yunsheng.leetcode.practise;

public class SearchinRotatedSortedArray {
	
	public static int search(int[] A, int target) {
		if(A.length == 0)
			return -1;
		
		int start = 0;
		int end = A.length - 1;
		int mid = (start + end)/2;
		
		while(start <= end) {
			mid = (start + end)/2;
			if(A[mid] == target)
				return mid;
			else if(A[mid] >= A[start]) {
				if(A[mid] > target && A[start] <= target)
					end = mid - 1;
				else
					start = mid + 1;
			}					
			else {
				if(A[mid] < target && A[end] >= target)
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,1};
		System.out.println(search(a,3));
	}

}
