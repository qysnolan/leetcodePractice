package yunsheng.leetcode.practise;

public class ListNode {
	
	int val;
    ListNode next;
    
    ListNode(int x) {
        val = x;
        next = null;
    }
    
    public String toString() {
    	return Integer.toString(val);
    }
    
    public void printNode() {
    	System.out.println(val);
    }
    
    public void printList() {
    	ListNode runner = this;
    	while(runner != null) {
    		System.out.print(runner.val);
    		if(runner.next != null)
    			System.out.print("-");
    		runner = runner.next;
    	}
    	System.out.println();
    }
    
    public ListNode testCast(int len, int range) {
    	
    	ListNode re = new ListNode((int)(Math.random()*range));
    	ListNode last = re;
    	for(int i = 0; i < len-1; i++) {
    		ListNode node = new ListNode((int)(Math.random()*range));
    		last.next = node;
    		last = node;
    	}
    	
      	return re;
    }
    
    public void testCastAddCycle(int len) {
    	ListNode cycle = this;
    	for(int i = 0; i < len-1; i++) 
    		cycle = cycle.next;
    	
    	ListNode last = this;
    	while(last.next != null)
    		last = last.next;
    	
    	last.next = cycle;
    }
    
    public ListNode generateList(int[] array) {
    	ListNode head = new ListNode(0);
    	ListNode cur = head;
    	
    	for(Integer i : array) {
    		cur.next = new ListNode(i);
    		cur = cur.next;
    	}
    	
    	return head.next;
    }
}
