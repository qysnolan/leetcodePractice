package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {
	
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size()==0) 
            return null;
        if(lists.size()==1) 
            return lists.get(0);
            
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), new ListNodeComparator());
        for(ListNode node : lists) {
            if(node != null)
                q.offer(node);
        }
            
        ListNode re = new ListNode(0);
        ListNode runner = re;
        while(!q.isEmpty()) {
            ListNode tmp = q.poll();
            runner.next = tmp;
            if(tmp.next != null)
                q.offer(tmp.next);
            runner = runner.next;
        }
        return re.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ListNodeComparator implements Comparator<ListNode>{
    public int compare(ListNode a, ListNode b) {
        if(a.val > b.val)
            return 1;
        else if(a.val < b.val)
            return -1;
        else
            return 0;
    }
}
