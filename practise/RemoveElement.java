package yunsheng.leetcode.practise;

public class RemoveElement {
	
	public int removeElement(int[] A, int elem) {
        if(A.length==0||A==null) 
        	return 0;
        
        int front = 0;
        int rear = A.length - 1;
        while(front<=rear) {
            if(A[front]==elem) {
                int temp = A[front];
                A[front] = A[rear];
                A[rear] = temp;
                rear--;
            }
            else front++;
        }
        return rear + 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
