package yunsheng.leetcode.practise;

public class ContainerwithMostWater {
	
	public int maxArea(int[] height) {
        if(height.length < 2)
            return 0;
        int front = 0;
        int rear = height.length - 1;
        int re = 0;
        while(front < rear) {
            int area = 0;
            if(height[front] < height[rear]) {
                area = (rear - front) * height[front];
                front++;
            }
            else {
                area = (rear - front) * height[rear];
                rear--;
            }
            if(area > re)
                re = area;
        }
        return re;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
