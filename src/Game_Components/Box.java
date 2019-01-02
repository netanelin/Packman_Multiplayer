package Game_Components;

import Ratio.Ratio_Segment;
import Ratio.Ratio_Point;

public class Box {

	private Ratio_Point min_ratio;
	private Ratio_Point max_ratio;

	public Box(String line, Map map){
		String[] data = line.split(",");
    	Coords.LatLonAlt min = new Coords.LatLonAlt(Double.parseDouble(data[2]),Double.parseDouble(data[3]),0);
    	Coords.LatLonAlt max = new Coords.LatLonAlt(Double.parseDouble(data[5]),Double.parseDouble(data[6]),0);
    	
    	min_ratio = new Ratio_Point(min, map);
		max_ratio = new Ratio_Point(max, map);
	}

	public Ratio_Point getMin_ratio() {
		return min_ratio;
	}

	public void setMin_ratio(Ratio_Point min_ratio) {
		this.min_ratio = min_ratio;
	}

	public Ratio_Point getMax_ratio() {
		return max_ratio;
	}

	public void setMax_ratio(Ratio_Point max_ratio) {
		this.max_ratio = max_ratio;
	}

	public boolean is_in_box(Ratio_Point ratio) {
		return ratio.getX_Ratio()>=min_ratio.getX_Ratio() && 
				ratio.getX_Ratio()<=max_ratio.getX_Ratio() &&
				ratio.getY_Ratio()<=min_ratio.getY_Ratio() &&
						ratio.getY_Ratio()>=max_ratio.getY_Ratio();
	}
	
	public boolean intersect(Ratio_Segment seg) {
		
		Ratio_Point bottom_left = min_ratio;
		Ratio_Point bottom_right = new Ratio_Point(max_ratio.getX_Ratio(), min_ratio.getY_Ratio());
		Ratio_Point top_left = new Ratio_Point(min_ratio.getX_Ratio(), max_ratio.getY_Ratio());
		Ratio_Point top_right = max_ratio;
		
		Ratio_Segment bottom = new Ratio_Segment(bottom_left, bottom_right);
		Ratio_Segment top = new Ratio_Segment(top_left, top_right);
		Ratio_Segment right = new Ratio_Segment(bottom_right, top_right);
		Ratio_Segment left = new Ratio_Segment(bottom_left, top_left);
		
		return seg.intersect(bottom) || seg.intersect(top) || seg.intersect(right) || seg.intersect(left);
	}
}
