package yunsheng.leetcode.practise;

public class Candy {
	
	public static int candy(int[] ratings) {
		int len = ratings.length;
		if(len == 0 || len == 1)
			return len;
		
		int[] candies = new int[len];
		int cur = 1;
		candies[0] = 1;
		for(int i = 1; i < len; i++) {
			if(ratings[i-1] < ratings[i])
				cur++;
			else
				cur = 1;
			candies[i] = cur;
		}
		
		int sum = 0;
		cur = 1;
		for(int i = len - 2; i >= 0; i--) {
			if(ratings[i] > ratings[i+1])
				cur++;
			else
				cur = 1;
			sum += Math.max(candies[i], cur);
		}
		sum += candies[len-1];
		
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {1,2,2};
		System.out.println(candy(A));

	}

}
