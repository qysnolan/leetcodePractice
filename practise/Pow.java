package yunsheng.leetcode.practise;

public class Pow {
	
	public double pow(double x, int n) {
        boolean positive = n>=0?true:false;
        int nabs = n==Integer.MIN_VALUE?Integer.MAX_VALUE:Math.abs(n);
        double product = n==Integer.MIN_VALUE?powHelper(x,nabs)*x:powHelper(x, nabs);
        // double product = powHelper(x, Math.abs(n));
        return positive?product:1/product;
    }
    public double powHelper(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        double temp = powHelper(x, n/2);
        return temp*temp*powHelper(x, n%2);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
