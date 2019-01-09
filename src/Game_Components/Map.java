package Game_Components;

import Coords.LatLonAlt;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class represents a map, with min and max LatLonAlt location points and map Image.
 * @author Eitan Lichtman, Netanel Indik
 */
public class Map {
	
	/**
	 * Initiates the map Image, min max LatLonAlt points by given coordinates.
	 * @param min
	 * @param max
	 */
    public Map(LatLonAlt min, LatLonAlt max){
        try {
            myImage = ImageIO.read(new File("Images\\ariel_university.jpg"));
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

	public BufferedImage getMyImage() {
		return myImage;
	}
    
	
	
	//********************private data and methods********************

	private BufferedImage myImage;
    private LatLonAlt min;
    private LatLonAlt max;
}
