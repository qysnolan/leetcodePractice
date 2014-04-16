package yunsheng.leetcode.practise;

public class RemoveNthNodeFromEndofList {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        ListNode foo = new ListNode(0);
        foo.next = head;
        ListNode fast = foo;
        ListNode slow = foo;
        while(fast.next != null) {
            if(n > 0) {
                fast = fast.next;
                n--;
                continue;
            }
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return foo.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
