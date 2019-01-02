package Ratio;

import java.awt.geom.Point2D;

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


	public boolean intersect(Ratio_Segment ot) {

		Ratio_Line_Equation e1 = new Ratio_Line_Equation(point1, point2);
		Ratio_Line_Equation e2 = new Ratio_Line_Equation(ot.point1, ot.point2);

		Ratio_Point intersection = e1.intersection_point(e2);

		double x = intersection.getX_Ratio();
		double y = intersection.getY_Ratio();

		
		return x<=Math.max(this.point1.getX_Ratio(), this.point2.getX_Ratio()) &&
		x>=Math.min(this.point1.getX_Ratio(), this.point2.getX_Ratio()) &&
		y<=Math.max(this.point1.getY_Ratio(), this.point2.getY_Ratio()) &&
		y>=Math.min(this.point1.getY_Ratio(), this.point2.getY_Ratio());

	}
}
