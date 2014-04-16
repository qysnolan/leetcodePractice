package yunsheng.leetcode.practise;

import java.util.ArrayList;

public class InsertInterval {
	
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> output = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            output.add(newInterval);
            return output;
        }
        int index = 0;
        for(int i=0; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(curr.end < newInterval.start){
                output.add(curr);
                index++;
            }
            else if(newInterval.end < curr.start)
                output.add(curr);
            else
                newInterval = new Interval(Math.min(newInterval.start, curr.start),
                                               Math.max(newInterval.end, curr.end));
        }
 
        output.add(index,newInterval);
        return output;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
