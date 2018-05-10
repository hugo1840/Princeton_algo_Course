package collinear;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point>{
	
	private int x;
	private int y;

	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	// x and y are between 0 and 32767
	public void draw(){
		StdDraw.point(x, y);
	}
	
	// StdDraw with input between 0 and 1
	public void drawTo(Point that){
		StdDraw.line(x, y, that.x, that.y);
	}
	
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	// implementation for Comparable
	public int compareTo(Point that) {
		if(y < that.y || (y == that.y && x < that.x)){
			return -1;
		}else if(y == that.y && x == that.x){
			return 0;
		}else{
			return 1;
		}	
	}
	
	public double slopeTo(Point that){
		if(this.compareTo(that) == 0){
			return Double.NEGATIVE_INFINITY;
		}else if(this.x == that.x){
			return Double.POSITIVE_INFINITY;
		}else if(this.y == that.y){
			return +0; // negative zero != positive zero
		}else{
			return (that.y - y) * 1.0 /(that.x - x); // integer to double
		}
	}
	
	public Comparator<Point> slopeOrder(){
		return new BySlope();
	}
	
	// implementation for Comparator
	private class BySlope implements Comparator<Point>{

		public int compare(Point o1, Point o2) {
			if(slopeTo(o1) < slopeTo(o2)) return -1;
			if(slopeTo(o1) > slopeTo(o2)) return 1;
			return 0;
		}	
	}

}
