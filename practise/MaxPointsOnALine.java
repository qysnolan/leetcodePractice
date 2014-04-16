package yunsheng.leetcode.practise;

import java.util.HashMap;

public class MaxPointsOnALine {
	
	public static int maxPoints(Point[] points) {
		if(points.length == 0)
			return 0;
		if(points.length == 1)
			return 1;
		
		int max = 1;
		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		
		for(int i = 0; i < points.length - 1; i++) {
			int vert = 0;
			int same = 1;
			for(int j = i + 1; j < points.length; j++) {
				if(points[i].x == points[j].x) {
					if(points[i].y == points[j].y)
						same++;
					else
						vert++;
					continue;
				}
				double k = (points[i].y == points[j].y) ? 
						0.0 : (1.0*(points[i].y - points[j].y)/(points[i].x - points[j].x));
				if(!map.containsKey(k))
					map.put(k, 1);
				else
					map.put(k, map.get(k) + 1);
			}
			for(Integer e : map.values())
				max = Math.max(max, e + same);
			max = Math.max(max, vert + same);
			map.clear();
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point();
		System.out.println(maxPoints(p.testCast(10, 100000)));
	}

}
