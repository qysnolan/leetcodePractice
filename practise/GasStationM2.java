package yunsheng.leetcode.practise;

public class GasStationM2 {

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		
		int sum = 0, total = 0, len = gas.length, index = -1;
		for (int i = 0; i < len; i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (sum < 0) {
				index = i;
				sum = 0;
			}
		}
		return total >= 0 ? index + 1 : -1;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] gas = {2,4};
		int[] cost = {1,4};
		System.out.println(canCompleteCircuit(gas, cost));
	}

}
