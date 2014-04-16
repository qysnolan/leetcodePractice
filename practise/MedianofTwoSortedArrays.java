package yunsheng.leetcode.practise;

public class MedianofTwoSortedArrays {
	
	public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        if(m == 0 && n == 0)
            return 0;
        if ((m + n) % 2 != 0) // odd
    		return (double) findKth(A, B, (m + n) / 2);
    	else // even
    		return (findKth(A, B, (m + n) / 2)  + findKth(A, B, (m + n) / 2 - 1)) * 0.5;
    }
        
    public int findKth(int A[], int B[], int k) {
    	if(A.length == 0)
    		return B[k];
    	if(B.length == 0)
    		return A[k];
    	int i = 0;
    	int j = 0;
    	int count = 0;
    	
    	while(i < A.length && j < B.length) {
    		if(A[i] <= B[j]) {
    			if(count == k)
        			return A[i];
    			i++;       					
    		}
    		else {
    			if(count == k)
        			return B[j];
    			j++;
    		}
    		count++;
    	}
    	if(i >= A.length) 
    		return B[j + k - count];
    	else
    		return A[i + k - count];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
