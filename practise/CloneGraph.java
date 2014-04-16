package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null)
			return null;
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = 
				new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode re = new UndirectedGraphNode(node.label);
		map.put(node, re);
		ArrayList<UndirectedGraphNode> q = new ArrayList<UndirectedGraphNode>();
		q.add(node);
		
		while(!q.isEmpty()) {
			UndirectedGraphNode n = q.remove(0);
			UndirectedGraphNode copy = map.get(n);
			ArrayList<UndirectedGraphNode> tmp = n.neighbors;
			for(UndirectedGraphNode ne : tmp) {
				UndirectedGraphNode c;
				if(map.containsKey(ne)) {			
					c = map.get(ne);
				}
				else {
					q.add(ne);
					c = new UndirectedGraphNode(ne.label);
					map.put(ne, c);
				}
				copy.neighbors.add(c);
			}
			
		}
				
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
