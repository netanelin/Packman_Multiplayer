package Game_Elements;

import Coords.LatLonAlt;

public class Element {

    private LatLonAlt gps_point;
    private char element_type;

    public Element (String line){
        String[] data = line.split(",");
        element_type = data[0].charAt(0);
        gps_point = new LatLonAlt(Double.parseDouble(data[2]),Double.parseDouble(data[3]),0);
    }

	public LatLonAlt getGps_point() {
		return gps_point;
	}

	public void setGps_point(LatLonAlt gps_point) {
		this.gps_point = gps_point;
	}

	public char getElement_type() {
		return element_type;
	}

	public void setElement_type(char element_type) {
		this.element_type = element_type;
	}
    
    
}
