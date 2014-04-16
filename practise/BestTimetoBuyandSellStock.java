package yunsheng.leetcode.practise;

public class BestTimetoBuyandSellStock {
	
	public static int maxProfit(int[] prices) {
		int len = prices.length;
		if(len <= 1)
			return 0;
		
		int re = 0;
		int small = 0;
		for(int i = 1; i < len; i++) {
			int profit = prices[i] - prices[small];
			if(profit <= 0)
				small = i;
			else 
				re = Math.max(profit, re);
		}
		
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {6,2,8,4,1,3,6};
		System.out.println(maxProfit(a));
	}

}
