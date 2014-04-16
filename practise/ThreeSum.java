package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        if(num.length < 3) 
            return result;
        Arrays.sort(num);
        int front;
        int rear;
        
        for(int i=0; i<num.length-2; i++) {
            if (i == 0 || num[i] > num[i - 1]) {
            	front = i + 1;
                rear = num.length - 1;
                while(front < rear) {           
                    if(num[front] + num[rear] < -num[i]) 
                        front++;
                    else if(num[front] + num[rear] > -num[i])
                        rear--;
                    else {
                    	ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[front]);
                        tmp.add(num[rear]);
                        result.add(tmp);
                        front++;
                        rear--;
                        while (front < rear && num[rear] == num[rear + 1])
    						rear--;
    					while (front < rear && num[front] == num[front - 1])
    						front++;
                    }
                }
            }
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
