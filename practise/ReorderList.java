package yunsheng.leetcode.practise;

public abstract class ReorderList {
	
	public static void reorderList(ListNode head) {
		if(head == null || head.next == null)
			return;
		
		ListNode second = separateList(head);
		second = reverseList(second);
		head = mergeTwoLists(head, second);
	}
	
	public static ListNode separateList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode second = slow.next;
		slow.next = null;
		return second;
	}
	
	public static ListNode reverseList(ListNode head) {
		ListNode cur = head;
		ListNode post = cur.next; 
		
        cur.next = null;  
        while (post != null) {  
            ListNode tmp = post.next;
            post.next = cur;
            cur = post;
            post = tmp;
        }  
        return cur;
	}
	
	public static ListNode mergeTwoLists(ListNode n1, ListNode n2) {
		ListNode r1 = n1;
		ListNode r2 = n2;
		
		while(r2 != null) {
			ListNode tmp1 = r1.next;
			ListNode tmp2 = r2.next;
			r1.next = r2;
			r2.next = tmp1;
			r1 = tmp1;
			r2 = tmp2;
		}
		
		return n1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(0).testCast(10, 1000);
		l.printList();
		reorderList(l);
		l.printList();;
	}

}
