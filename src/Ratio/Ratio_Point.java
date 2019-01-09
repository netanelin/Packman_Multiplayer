package Ratio;

import java.awt.*;

import Coords.LatLonAlt;
import Game_Components.Map;

/**
 * This class represents a ratio point.
 * Including x ratio that tells me the ratio of the x coordinate from the left side (left/full_width),
 * and y ratio that tells me the ratio of the y coordinate from the top down (top/full_height).
 * @author Eitan Lichtman, Netanel Indik
 */
public class Ratio_Point {

    public double getX_Ratio() {
        return X_Ratio;
    }

    public double getY_Ratio() {
        return Y_Ratio;
    }

    /**
     * Initiates Ratio_Point by given x and y ratio.
     * @param x_ratio
     * @param y_ratio
     */
    public Ratio_Point (double x_ratio, double y_ratio) {
    	X_Ratio = x_ratio;
    	Y_Ratio = y_ratio;
    }
    
    /**
     * Initiates Ratio_Point by given LatLonAlt point and map.
     * @param location
     * @param map
     */
    public Ratio_Point(LatLonAlt location, Map map){
        double map_width = map.getMax().lon()-map.getMin().lon();
        double left_to_point = location.lon()-map.getMin().lon();

        double map_height = map.getMax().lat()-map.getMin().lat();
        double top_to_point = map.getMax().lat()-location.lat();

        X_Ratio = left_to_point/map_width;
        Y_Ratio = top_to_point/map_height;
    }
    
    /**
     * Copy constructor.
     * @param ot
     */
    public Ratio_Point(Ratio_Point ot) {
    	X_Ratio = ot.X_Ratio;
    	Y_Ratio = ot.Y_Ratio;
    }
    
    /**
     * Initiates Ratio_Point by given pixel location point and full width and height.
     * @param pixel_location
     * @param width
     * @param height
     */
    public Ratio_Point(Point pixel_location, int width, int height ){
        X_Ratio = (double)pixel_location.x/width;
        Y_Ratio = (double)pixel_location.y/height;
    }

    /**
     * Converts ratio point to point in pixels.
     * @param width
     * @param height
     * @return point in pixels
     */
    public Point to_pixels (int width, int height){
        int  x = (int)(width*X_Ratio);
        int  y = (int)(height*Y_Ratio);
        Point p = new Point (x,y);
        return p;
    }
    
    /**
     * Converts ratio point to LatLonAlt point.
     * @param map
     * @return LatLonAlt point
     */
    public LatLonAlt to_latLon (Map map) {
    	double min_lat = map.getMin().x();
		double min_lon = map.getMin().y();
		double max_lat = map.getMax().x();
		double max_lon = map.getMax().y();

		double new_lat = min_lat + (max_lat-min_lat)*(1-Y_Ratio);
		double new_lon = min_lon + (max_lon-min_lon)*X_Ratio;

		return new Coords.LatLonAlt(new_lat, new_lon, 0);
    }
    

    
	//********************private data and methods********************
    
    private  double X_Ratio, Y_Ratio;
}
