package yunsheng.leetcode.practise;

public class NextPermutation {
	
	public void nextPermutation(int[] num) {
        if(num == null || num.length <= 1)
            return ;
        int index = num.length - 2;
        while(index >= 0 && num[index] >= num[index+1]) 
            index--;
        if(index == -1) 
            reverse(num, 0, num.length-1);
        else {
            int swapIndex = findSwap(num, index);
            swap(num, index, swapIndex);
            reverse(num, index+1, num.length-1);
        }
    }
    
    public int findSwap(int[] num, int index) {
        int runner = index + 1;
        while(num[runner] > num[index]) {
        	runner++;
        	if(runner >= num.length)
        		break;
        }
        return runner - 1;
    }
    
    public void reverse(int[] num, int start, int end) {
        while(start < end) {
            swap(num, start, end);
            start++;
            end--;
        }
    }
    
    public void swap(int[] num, int i1, int i2) {
        int tmp = num[i1];
        num[i1] = num[i2];
        num[i2] = tmp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
