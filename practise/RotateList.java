package yunsheng.leetcode.practise;

public class RotateList {
	
	public ListNode rotateRight(ListNode head, int n) {
        if(head == null) 
            return null;
        
        n = n%listLen(head);
        if(n == 0)
            return head;
        
        ListNode fast = head;
        int count = n;
        while(count > 0) {
            fast = fast.next;
            count--;
            if(fast == null)
                return head;
        }
        
        ListNode slow = head;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode tmp = slow.next;
        fast.next = head;
        head = tmp;
        slow.next = null;
        
        return head;
    }
	
	public int listLen(ListNode head) {
        if(head == null)
            return 0;
        int count = 0;
        ListNode curr = head;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
