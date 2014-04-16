package yunsheng.leetcode.practise;

public class BestTimetoBuyandSellStockII {
	
	public static int maxProfit(int[] prices) {
		int len = prices.length;
		if(len <= 1)
			return 0;
		
		int re = 0;
		int base = Integer.MAX_VALUE;
		for(int i = 0; i < len; i++) {
			if(prices[i] > base)
				re += prices[i] - base;
			base = prices[i];
		}
		
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {6,2,8,4,1,3,6};
		System.out.println(maxProfit(a));
	}

}
