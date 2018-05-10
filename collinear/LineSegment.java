package collinear;

import edu.princeton.cs.algs4.StdDraw;

public class LineSegment {
	
	private Point p_top;
	private Point p_bot;
	
	public LineSegment(Point p, Point q){
		p_top = p;
		p_bot = q;
	}
	
	public void draw(){
		p_top.drawTo(p_bot);
	}

	public String toString() {
		return "LineSegment [p1=" + p_top + ", p2=" + p_bot + "]";
	}

	public static void main(String[] args){
		Point p1 = new Point(15000,18000);
		Point p2 = new Point(8000,22000);
		Point p3 = new Point(600,9000);
		Point p4 = new Point(9000,5000);
		Point p5 = new Point(12000,10000);
		
		StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(StdDraw.BLUE);
		
		p1.draw();
		p2.draw();
		p3.draw();
		p4.draw();
		p5.draw();
		StdDraw.show();
		
		StdDraw.setPenColor(StdDraw.MAGENTA);
		p1.drawTo(p5);
		p2.drawTo(p4);
		StdDraw.setPenColor(StdDraw.RED);
		p3.drawTo(p2);
		StdDraw.show();
			
	}
}
