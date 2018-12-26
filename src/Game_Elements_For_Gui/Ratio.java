package Game_Elements_For_Gui;

import Coords.LatLonAlt;

import java.awt.*;

public class Ratio{
    private  double X_Ratio, Y_Ratio;

    public double getX_Ratio() {
        return X_Ratio;
    }

    public double getY_Ratio() {
        return Y_Ratio;
    }

    public Ratio (LatLonAlt location, Gui_Map map ){
        double map_width = map.getMax().lon()-map.getMin().lon();
        double left_to_point = location.lon()-map.getMin().lon();

        double map_height = map.getMax().lat()-map.getMin().lat();
        double top_to_point = map.getMax().lat()-location.lat();

        X_Ratio = left_to_point/map_width;
        Y_Ratio = top_to_point/map_height;
    }

    public Point to_pixels (int width, int height){

        int  x = (int)(width*X_Ratio);
        int  y = (int)(height*Y_Ratio);
        Point p = new Point (x,y);
        return p;
    }

}
