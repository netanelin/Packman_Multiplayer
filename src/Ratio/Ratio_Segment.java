package Ratio;

public class Ratio_Segment {

	private Ratio_Point point1;
	private Ratio_Point point2;

	public Ratio_Segment(Ratio_Point p1, Ratio_Point p2) {
		point1 = new Ratio_Point(p1);
		point2 = new Ratio_Point(p2);
	}

	public Ratio_Point getPoint1() {
		return point1;
	}

	public void setPoint1(Ratio_Point point1) {
		this.point1 = point1;
	}

	public Ratio_Point getPoint2() {
		return point2;
	}

	public void setPoint2(Ratio_Point point2) {
		this.point2 = point2;
	}

	
	private boolean parallel_2_y(Ratio_Point p1, Ratio_Point p2) {
		return p1.getX_Ratio()==p2.getX_Ratio();
	}
	
	
	
	public boolean intersect(Ratio_Segment ot) { 
		
		double x1 = point1.getX_Ratio();
		double y1 = point1.getY_Ratio();
		double x2 = point2.getX_Ratio();
		double y2 = point2.getY_Ratio();
		
		double x3 = ot.point1.getX_Ratio();
		double y3 = ot.point1.getY_Ratio();
		double x4 = ot.point2.getX_Ratio();
		double y4 = ot.point2.getY_Ratio();
		
		double bx = x2 - x1; 
		double by = y2 - y1; 
		double dx = x4 - x3; 
		double dy = y4 - y3;
		double b_dot_d_perp = bx * dy - by * dx;
		  if (b_dot_d_perp == 0) {
		    return false;
		  }
		  double cx = x3 - x1;
		  double cy = y3 - y1;
		  double t = (cx * dy - cy * dx) / b_dot_d_perp;
		  if (t < 0 || t > 1) {
		    return false;
		  }
		  double u = (cx * by - cy * bx) / b_dot_d_perp;
		  if (u < 0 || u > 1) { 
		    return false;
		  }
		  return true;
		}
	
	
	
//	
//	public boolean intersect(Ratio_Segment ot) {
//
//		Ratio_Line_Equation e1 = new Ratio_Line_Equation(point1, point2);
//		Ratio_Line_Equation e2 = new Ratio_Line_Equation(ot.point1, ot.point2);
//
//		if(parallel_2_y(point1, point2) && parallel_2_y(ot.point1, ot.point2)) {
//			return e1.p1.getX_Ratio() == e2.p1.getX_Ratio();
//		}
//		Ratio_Point intersection = null;
//		if(parallel_2_y(point1, point2)) {
//			double x1 = point1.getX_Ratio();
//			double y1 = e2.m*x1 + e2.n;
//			intersection = new Ratio_Point(x1, y1);
//		}
//		else if(parallel_2_y(ot.point1, ot.point2)) {
//			double x2 = ot.point1.getX_Ratio();
//			double y2 = e1.m*x2 + e1.n;
//			intersection = new Ratio_Point(x2, y2);
//		}
//		else {
//			intersection = e1.intersection_point(e2);
//		}
//
//		double x = intersection.getX_Ratio();
//		double y = intersection.getY_Ratio();
//		
//		//check whether the intersection point is on both segments
//		boolean intersect = x<=Math.max(this.point1.getX_Ratio(), this.point2.getX_Ratio()) &&
//							x>=Math.min(this.point1.getX_Ratio(), this.point2.getX_Ratio()) &&
//							y<=Math.max(this.point1.getY_Ratio(), this.point2.getY_Ratio()) &&
//							y>=Math.min(this.point1.getY_Ratio(), this.point2.getY_Ratio()) &&
//							x<=Math.max(ot.point1.getX_Ratio(), ot.point2.getX_Ratio()) &&
//							x>=Math.min(ot.point1.getX_Ratio(), ot.point2.getX_Ratio()) &&
//							y<=Math.max(ot.point1.getY_Ratio(), ot.point2.getY_Ratio()) &&
//							y>=Math.min(ot.point1.getY_Ratio(), ot.point2.getY_Ratio());
//		return intersect;
//	}
}
