package yunsheng.leetcode.practise;

public class Sqrt {
	
	public int sqrt(int x) {
        if(x<0) 
        	return -1;
        if(x==0) 
        	return 0;
        
        long front = 0;
        long rear = x;
        long mid;
        
        while(front<=rear) {
            mid = (front+rear)/2;
            if(mid*mid==x) 
            	return (int)mid;
            else if(mid*mid<x) 
            	front = mid + 1;
            else 
            	rear = mid - 1;
        }
        
        mid = (front+rear)/2;
        return (int)mid;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
