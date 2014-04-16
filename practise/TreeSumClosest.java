package yunsheng.leetcode.practise;

import java.util.Arrays;

public class TreeSumClosest {
	
	public int threeSumClosest(int[] num, int target) {
        if(num.length < 3)
            return 0;
        Arrays.sort(num);
        int front = 0;
        int rear = num.length - 1;
        int sum = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < num.length; i++) {
            if(i == 0 || num[i] > num[i-1]) {
                front = i + 1;
                rear = num.length - 1;
                while(front < rear) {  
                    int tmp = Math.abs(target - num[front] - num[rear] - num[i]);
                    if(tmp == 0)
                        return num[front] + num[rear] + num[i];
                    if(tmp < min) {
                        min = tmp;
                        sum = num[front] + num[rear] + num[i];
                    }
                    if(num[front] + num[rear] < -num[i] + target) 
                        front++;
                    else if(num[front] + num[rear] > -num[i] + target) 
                        rear--;
                    else {
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
        return sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
