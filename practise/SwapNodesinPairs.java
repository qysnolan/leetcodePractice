package yunsheng.leetcode.practise;

public class SwapNodesinPairs {
	
	public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) 
        	return head;
        
        ListNode front = head;
        ListNode rear = head.next;
        int temp = 0;
        while(front != null && rear != null) {
            temp = front.val;
            front.val = rear.val;
            rear.val = temp;
            front = rear.next;
            
            if(rear.next != null) 
            	rear = rear.next.next;
            else 
            	rear = null;
        }
        
        return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
