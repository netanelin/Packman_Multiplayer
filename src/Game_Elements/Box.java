package Game_Elements;

import Coords.LatLonAlt;
import Ratio.Ratio_Point;

public class Box {

	private Ratio_Point min_ratio;
	private Ratio_Point max_ratio;

	public Box(String line, Map map){
		String[] data = line.split(",");
    	LatLonAlt min = new LatLonAlt(Double.parseDouble(data[2]),Double.parseDouble(data[3]),0);
    	LatLonAlt max = new LatLonAlt(Double.parseDouble(data[5]),Double.parseDouble(data[6]),0);
    	
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
}
