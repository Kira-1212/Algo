import java.util.HashSet;
import java.util.Set;

public class ConvexHullDC {

	// for storing the points on the hull, we take set because we will duplicate values
	Set<Point> convexHull = new HashSet<Point>();
	public static void main(String args[]) {
		//creating array of points
		Point[] points = new Point[26];
		points[0] = new Point(152, 202);
		points[1] = new Point(549, 234);
		points[2] = new Point(266, 342);
		points[3] = new Point(274, 245);
		points[4] = new Point(329, 155);
		points[5] = new Point(409, 69);
		points[6] = new Point(499, 203);
		points[7] = new Point(441, 330);
		points[8] = new Point(375, 378);
		points[9] = new Point(362, 267);
		points[10] = new Point(330, 369);
		points[11] = new Point(485, 333);
		points[12] = new Point(188, 304);
		points[13] = new Point(287, 279);
		points[14] = new Point(356, 311);
		points[15] = new Point(431, 282);
		points[16] = new Point(375, 228);
		points[17] = new Point(217, 296);
		points[18] = new Point(237, 177);
		points[19] = new Point(275, 78);
		points[20] = new Point(203, 107);
		points[21] = new Point(462, 137);
		points[22] = new Point(379, 167);
		points[23] = new Point(365, 88);
		points[24] = new Point(509, 114);
		points[25] = new Point(253, 112);
		
//		
		ConvexHullDC cdc = new ConvexHullDC();
		
//		for(int i =0 ; i<points.length; i++) {
//			System.out.print(points[i].x + " ");
//			System.out.println(points[i].y);
//		}
		
		cdc.Hull(points);
		
	}
	
	
	// checks for the feasibily of forming a hull and then splits the points
	public void Hull(Point[] points) {
		int n = points.length;
		if(n<3) {
			System.out.println("Can't create Hull");
			return;
		}
		int maxX = 0, minX = 0;
		
		// we do this to find out the largest line possible in the given set of points
		for(int i = 1; i < n ; i++) {
			if(points[i].x < points[minX].x)
				minX = i;
			if(points[i].x > points[maxX].x)
				maxX = i;
				
		}
		//using the endpoints of the largest line we split the points into two halves
		findHull(points, n, points[minX], points[maxX], 1);
		findHull(points, n, points[minX], points[maxX], -1);
		
		
		for(Point p : convexHull) {
			System.out.println("(" + p.x + " ," + p.y + ")" );
		}
	}
	// checks the points w.r.t to the line and adds it the hull recursively
	public void findHull(Point[] points, int n, Point point1, Point point2, int side) {
		int index = -1, maxDistance = 0;
		
		for(int i = 0; i<n; i++){
			int lineDistance = distance(point1, point2, points[i]);
			if((getSide(point1, point2, points[i]) == side) && lineDistance > maxDistance){
				index = i;
				maxDistance = lineDistance;
			}
		}
		if(index == -1) {
			convexHull.add(point1);
			convexHull.add(point2);
			return;
		}
		
		findHull(points, n, points[index], point1, -getSide(points[index], point1, point2));
		
		findHull(points, n, points[index], point2, -getSide(points[index], point2, point1));
		
		
		
		
	}

	// to find out region/side of the point w.r.t the line
	public int getSide(Point point1, Point point2, Point point) {
		int distance = (point.y - point1.y) * (point2.x - point1.x) - (point2.y - point1.y) * (point.x - point1.x);
		if(distance > 0)
			return 1;
		else if(distance < 0)
			return -1;
		else
			return 0;
	}

	public int distance(Point point1, Point point2, Point point) {
		
		return Math.abs((point.y - point1.y) * (point2.x - point1.x) - (point2.y - point1.y) * (point.x - point1.x));
	}
}


