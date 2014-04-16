package yunsheng.leetcode.practise;

public class RandomListNode {		
	int label;
	RandomListNode next, random;
	
	RandomListNode(int x) { 
		this.label = x; 
	}
	
	public String toString() {
    	return Integer.toString(label);
    }
    
    public void printNode() {
    	System.out.println(label);
    }
    
    public void printList() {
    	RandomListNode runner = this;
    	while(runner != null) {
    		System.out.print(runner.label);
    		if(runner.next != null)
    			System.out.print("-");
    		runner = runner.next;
    	}
    	System.out.println();
    }
    
    public RandomListNode testCast(int len, int range) {
    	
    	RandomListNode re = new RandomListNode((int)(Math.random()*range));
    	RandomListNode last = re;
    	for(int i = 0; i < len-1; i++) {
    		RandomListNode node = new RandomListNode((int)(Math.random()*range));
    		last.next = node;
    		last = node;
    		if(Math.random() > 0.5)
    			node.random = last;
    	}
    	last.random = re;
    	re.random = last;
    	
      	return re;
    }
}
