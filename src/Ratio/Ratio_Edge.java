package Ratio;

public class Ratio_Edge {
	
	private Ratio_Point point1;
	private Ratio_Point point2;
	
	public Ratio_Edge(Ratio_Point p1, Ratio_Point p2) {
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
	
	public boolean touches_other_edge(Ratio_Edge ot) {
		
	}
}
