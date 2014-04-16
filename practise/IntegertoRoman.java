package yunsheng.leetcode.practise;

public class IntegertoRoman {
	
	public String intToRoman(int num) {
        String[] one = {"I", "X", "C", "M"};
        String[] five = {"V", "L", "D", ""};
        String numStr = num + "";
        String result = "";
        for(int i=numStr.length()-1; i>=0; i--) {
            int bit = (int)num%(int)Math.pow(10, i+1)/(int)Math.pow(10, i);
            String temp = "";
            switch(bit) {
                case 1: temp = one[i];
                        break;
                case 2: temp = one[i] + one[i];
                        break;
                case 3: temp = one[i] + one[i] + one[i];
                        break;
                case 4: temp = one[i] + five[i];
                        break;
                case 5: temp = five[i];
                        break;
                case 6: temp = five[i] + one[i];
                        break;
                case 7: temp = five[i] + one[i] + one[i];
                        break;
                case 8: temp = five[i] + one[i] + one[i] + one[i];
                        break;
                case 9: temp = one[i] + one[i+1];
                        break;
                default: temp = "";
                        break;
            }
            result = result + temp;
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
