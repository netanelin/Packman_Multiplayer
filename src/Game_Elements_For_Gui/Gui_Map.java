package Game_Elements_For_Gui;

import Coords.LatLonAlt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Gui_Map {

    private Image myImage;
    private LatLonAlt min;
    private LatLonAlt max;

    public Gui_Map(LatLonAlt min, LatLonAlt max){
        try {
            myImage = ImageIO.read(new File("Images\\image.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.min = new LatLonAlt(min);
        this.max = new LatLonAlt(max);
    }

    public LatLonAlt getMin() {
        return min;
    }

    public LatLonAlt getMax() {
        return max;
    }
}
