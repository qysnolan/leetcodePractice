package yunsheng.leetcode.practise;

public class InsertionSortList {
	
	public static ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode re = new ListNode(Integer.MIN_VALUE);
		ListNode r = head;
		while(r != null) {
			ListNode tmp = r;
			r = r.next;
			tmp.next = null;
			insert(re, tmp);
		}
		
		return re.next;
	}
	
	public static ListNode insert(ListNode list, ListNode node) {
		
		ListNode re = new ListNode(Integer.MIN_VALUE);
		re.next = list;
		ListNode r = list;
		while(r.next != null) {
			if(r.next.val >= node.val) {
				node.next = r.next;
				r.next = node;
				break;
			}				
			r = r.next;
		}
		if(r.next == null)
			r.next = node;
		
		return re.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(0).testCast(10, 1000);
		l.printList();
		insertionSortList(l).printList();;
	}

}
