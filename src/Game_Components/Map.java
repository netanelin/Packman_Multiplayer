package Game_Components;

import Coords.LatLonAlt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Map {

	private BufferedImage myImage;
    private LatLonAlt min;
    private LatLonAlt max;

    public Map(LatLonAlt min, LatLonAlt max){
        try {
            myImage = ImageIO.read(new File("Images\\ariel_university.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.min = new LatLonAlt(min);
        this.max = new LatLonAlt(max);
    }
    
    public Map(Map ot) {
    	min = new LatLonAlt(ot.min);
    	max = new LatLonAlt(max);
    	myImage = ot.myImage;
    }

    public LatLonAlt getMin() {
        return min;
    }

    public LatLonAlt getMax() {
        return max;
    }

	public BufferedImage getMyImage() {
		return myImage;
	}
    
    
}
