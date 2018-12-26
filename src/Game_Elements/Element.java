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
}
