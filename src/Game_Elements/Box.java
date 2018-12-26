package Game_Elements;

import Coords.LatLonAlt;

public class Box {
    private LatLonAlt min;
    private LatLonAlt max;

    public Box(String line){

    }


    public boolean is_in_box(LatLonAlt gps_point){
        return gps_point.lat()>=min.lat() && gps_point.lat()<=max.lat()
                && gps_point.lon()>=min.lon() && gps_point.lon()<=max.lon();
    }

}
