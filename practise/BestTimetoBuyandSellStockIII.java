package yunsheng.leetcode.practise;

public class BestTimetoBuyandSellStockIII {
	
	public static int maxProfit(int[] prices) {
		int len = prices.length;
		if(len <= 1)
			return 0;
		
		int re = 0;
		int[] left = new int[len];
		int[] right = new int[len];
		int min = prices[0];
		int max = prices[len-1];
		for(int i = 1; i < len; i++) {
			if(prices[i] < min)
				min = prices[i];
			left[i] = Math.max(left[i-1], prices[i] - min);
		}
		for(int i = len-2; i >= 0; i--) {
			if(prices[i] > max)
				max = prices[i];
			right[i] = Math.max(right[i+1], max - prices[i]);
		}
		for(int i = 0; i < len; i++)
			re = Math.max(re, left[i] + right[i]);
		
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {6,2,8,4,1,3,6};
		System.out.println(maxProfit(a));
	}

}
