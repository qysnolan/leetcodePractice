package yunsheng.leetcode.practise;

public class GasStation {
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas.length == 0 || cost.length == 0 || gas.length != cost.length)
			return -1;
		
		if(gas.length == 1)
		    if(gas[0] - cost[0] >= 0)
		        return 0;
		    else
		        return -1;
		
		int len = gas.length;
		Integer[] array = new Integer[len];
		for(int i = 0; i < len; i++) 
			array[i] =  gas[i] - cost[i];
		
		int count = compress(array);
		while(count != 0) 
			count = compress(array);	
		
		for(int i = 0; i < len; i++) {
			if(array[i] != null && array[i] >= 0)
				return (i + 1)%len;		
		}
		
		return -1;
	}
	
	public static int compress(Integer[] array) {
		int len = array.length;
		int count = 0;
		for(int i = 0; i < len; i++) {
			if(array[i] == null || !(array[i] < 0))
				continue;
			int j = (i - 1 + len)%len;
			while(j != i && array[j] != null && array[j] >= 0) {
				array[i] += array[j];
				array[j] = null;
				count++;
				j = (j - 1 + len)%len;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] gas = {2,4};
		int[] cost = {3,4};
		System.out.println(canCompleteCircuit(gas, cost));
	}

}
