package yunsheng.leetcode.practise;

public class Point {
	
	int x;
	int y;
	
	Point() { 
		x = 0; 
		y = 0; 
	}
	
	Point(int a, int b) { 
		x = a; 
		y = b; 
	}
	
	public void printPoint() {
		System.out.println("x: " + x + ", y: " + y + "");
	}
	
	public void printArray() {
		System.out.print("(" + x + "," + y + ")");
	}
	
	public Point[] testCast(int len, int range) {
		Point[] re = new Point[len];
		for(int i = 0; i < len; i++) {
			Point p = new Point((int)(Math.random()*range), (int)(Math.random()*range));
			re[i] = p;
			p.printArray();
		}
		System.out.println();
		
		return re;
	}

}
