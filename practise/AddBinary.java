package yunsheng.leetcode.practise;

public class AddBinary {
	
	public String addBinary(String a, String b) {
		char[] large;
		char[] small;
		int len = 0;
        if(a.length()>b.length()) {
            large = a.toCharArray();
            small = b.toCharArray();
            len = a.length() + 1;
        }
        else {
            large = b.toCharArray();
            small = a.toCharArray();
            len = b.length() + 1;
        }
        Character[] result = new Character[len];
		int countSmall = small.length - 1;
        int carry = 0;
        
        for(int i=large.length-1; i>=0; i--) {
            int l = (int)large[i] - 48;
            int r = 0;
            if(countSmall>=0) {
                int s = (int)small[countSmall] - 48;
                r = s + l + carry;
                countSmall--;
            }
            else {
                r = l + carry;
            }
            if(r==0) {
                result[i+1] = '0';
                carry = 0;
            }
            else if(r==1) {
                result[i+1] = '1';
                carry = 0;
            }
            else if(r==2) {
                result[i+1] = '0';
                carry = 1;
            }
            else {
                result[i+1] = '1';
                carry = 1;
            }
        }
        String str = "";
        if(carry==1) {
        	result[0] = '1';
        	for (Character c : result)
                str += c.toString();  
        }
        else {
        	for (int i=1; i<result.length; i++)
                str += result[i].toString();
        }
              
        return str;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
