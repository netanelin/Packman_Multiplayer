package Ratio;

public class Ratio_Line_Equation {

	public double m, n;

	public Ratio_Line_Equation(Ratio_Point p1, Ratio_Point p2) {
		line_equation(p1, p2);
	}


	private void line_equation(Ratio_Point p1, Ratio_Point p2) {
		double x1 =p1.getX_Ratio();
		double x2 =p2.getX_Ratio();
		double y1 =p1.getY_Ratio();
		double y2 =p2.getY_Ratio();

		m = (y1-y2)/(x1-x2);
		n = y1-m*x1;
	}
	
	public Ratio_Point intersection_point(Ratio_Line_Equation ot) {
		
		double x = (ot.n-n) / (m-ot.m);
		double  y = m*x+n;
		
		return new Ratio_Point(x, y);
	}
	
}