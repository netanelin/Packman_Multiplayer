package Game_Components;

import Ratio.Ratio_Segment;
import Ratio.Ratio_Point;

public class Box {

	private Ratio_Point bottom_left;
	private Ratio_Point top_right;
	private Ratio_Point bottom_right;
	private Ratio_Point top_left;

	public Box(String line, Map map){
		String[] data = line.split(",");
		Coords.LatLonAlt min = new Coords.LatLonAlt(Double.parseDouble(data[2]),Double.parseDouble(data[3]),0);
		Coords.LatLonAlt max = new Coords.LatLonAlt(Double.parseDouble(data[5]),Double.parseDouble(data[6]),0);

		bottom_left = new Ratio_Point(min, map);
		top_right = new Ratio_Point(max, map);

		bottom_right = new Ratio_Point(top_right.getX_Ratio(), bottom_left.getY_Ratio());
		top_left = new Ratio_Point(bottom_left.getX_Ratio(), top_right.getY_Ratio());
		
	}

	public Box(Ratio_Point min, Ratio_Point max) {
		bottom_left = new Ratio_Point(min);
		top_right = new Ratio_Point(max);
		
		bottom_right = new Ratio_Point(top_right.getX_Ratio(), bottom_left.getY_Ratio());
		top_left = new Ratio_Point(bottom_left.getX_Ratio(), top_right.getY_Ratio());
	}
	
	public Ratio_Point getBottom_left() {
		return bottom_left;
	}

	public void setBottom_left(Ratio_Point bottom_left) {
		this.bottom_left = bottom_left;
	}

	public Ratio_Point getBottom_right() {
		return bottom_right;
	}

	public Ratio_Point getTop_left() {
		return top_left;
	}

	public Ratio_Point getTop_right() {
		return top_right;
	}

	public void setTop_right(Ratio_Point top_right) {
		this.top_right = top_right;
	}

	public boolean is_in_box(Ratio_Point ratio) {
		return ratio.getX_Ratio()>= bottom_left.getX_Ratio() &&
				ratio.getX_Ratio()<= top_right.getX_Ratio() &&
				ratio.getY_Ratio()<= bottom_left.getY_Ratio() &&
				ratio.getY_Ratio()>= top_right.getY_Ratio();
	}

	public boolean intersect(Ratio_Segment seg) {

		Ratio_Segment bottom = new Ratio_Segment(bottom_left, bottom_right);
		Ratio_Segment top = new Ratio_Segment(top_left, top_right);
		Ratio_Segment right = new Ratio_Segment(bottom_right, top_right);
		Ratio_Segment left = new Ratio_Segment(bottom_left, top_left);

		return seg.intersect(bottom) || seg.intersect(top) || seg.intersect(right) || seg.intersect(left);
	}
}
