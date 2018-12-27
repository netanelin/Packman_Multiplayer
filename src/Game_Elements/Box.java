package Game_Elements;

import Coords.LatLonAlt;

public class Box {
    private LatLonAlt min;
    private LatLonAlt max;

    public Box(String line){
        String[] data = line.split(",");
    	min = new LatLonAlt(Double.parseDouble(data[2]),Double.parseDouble(data[3]),0);
    	max = new LatLonAlt(Double.parseDouble(data[5]),Double.parseDouble(data[6]),0);
    }


    public boolean is_in_box(LatLonAlt gps_point){
        return gps_point.lat()>=min.lat() && gps_point.lat()<=max.lat()
                && gps_point.lon()>=min.lon() && gps_point.lon()<=max.lon();
    }


	public LatLonAlt getMin() {
		return min;
	}


	public void setMin(LatLonAlt min) {
		this.min = min;
	}


	public LatLonAlt getMax() {
		return max;
	}


	public void setMax(LatLonAlt max) {
		this.max = max;
	}

}
