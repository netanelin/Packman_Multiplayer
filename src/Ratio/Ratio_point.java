package Ratio;

import Game_Elements.Map;

import java.awt.*;

public class Ratio_point {
    private  double X_Ratio, Y_Ratio;

    public double getX_Ratio() {
        return X_Ratio;
    }

    public double getY_Ratio() {
        return Y_Ratio;
    }

    public Ratio_point(Coords.LatLonAlt location, Map map ){
        double map_width = map.getMax().lon()-map.getMin().lon();
        double left_to_point = location.lon()-map.getMin().lon();

        double map_height = map.getMax().lat()-map.getMin().lat();
        double top_to_point = map.getMax().lat()-location.lat();

        X_Ratio = left_to_point/map_width;
        Y_Ratio = top_to_point/map_height;
    }
    
    public Ratio_point(Ratio_point ot) {
    	X_Ratio = ot.X_Ratio;
    	Y_Ratio = ot.Y_Ratio;
    }
    
    public Ratio_point(Point pixel_location, int width, int height ){
        X_Ratio = (double)pixel_location.x/width;
        Y_Ratio = (double)pixel_location.y/height;
    }

    public Point to_pixels (int width, int height){

        int  x = (int)(width*X_Ratio);
        int  y = (int)(height*Y_Ratio);
        Point p = new Point (x,y);
        return p;
    }
    
    public Coords.LatLonAlt to_latLon (Map map) {
    	double min_lat = map.getMin().x();
		double min_lon = map.getMin().y();
		double max_lat = map.getMax().x();
		double max_lon = map.getMax().y();

		double new_lat = min_lat + (max_lat-min_lat)*(1-Y_Ratio);
		double new_lon = min_lon + (max_lon-min_lon)*X_Ratio;

		return new Coords.LatLonAlt(new_lat, new_lon, 0);
    }

}
