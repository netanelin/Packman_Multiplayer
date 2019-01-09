package Ratio;

/**
 * This class represents a ratio segment which is a line between two ratio points.
 * @author Eitan Lichtman, Netanel Indik
 */
public class Ratio_Segment {

	/**
	 * Initiates Ratio_Segment by two given ratio points.
	 * @param p1
	 * @param p2
	 */
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
	
	/**
	 * @param ot
	 * @return true iff the two segments intersect.
	 */
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



	//********************private data and methods********************

	private Ratio_Point point1;
	private Ratio_Point point2;
}
