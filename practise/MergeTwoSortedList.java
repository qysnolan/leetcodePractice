package yunsheng.leetcode.practise;

public class MergeTwoSortedList {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
            
        ListNode result = new ListNode(0);
        ListNode runner = result;
        ListNode runner1 = l1;
        ListNode runner2 = l2;
        while(runner1 != null && runner2 != null) {
            if(runner1.val <= runner2.val) {
                runner.next = runner1;
                runner1 = runner1.next;
            }
            else {
                runner.next = runner2;
                runner2 = runner2.next;
            }
            runner = runner.next;
        }
        if(runner1 == null)
            runner.next = runner2;
        if(runner2 == null)
            runner.next = runner1;
            
        return result.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
