package Game_Components;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Ratio.Ratio_Point;

/**
 * This class represents a single packman with a Ratio_point location and Image.
 * @author Eitan Lichtman, Netanel Indik
 */
public class Packman implements Element{
	
	/**
	 * Initiates the packman by a given line from a csv file and a given map.
	 * @param line
	 * @param map
	 */
	public Packman (String line, Map map){
		 String[] data = line.split(",");
	       Coords.LatLonAlt gps_point = new Coords.LatLonAlt(Double.parseDouble(data[2]),Double.parseDouble(data[3]),0);
	       
			ratio = new Ratio_Point(gps_point , map);
			
			try {
				image = ImageIO.read(new File("Images\\packman.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}	
	}

	@Override
	public Ratio_Point getRatio() {
		return ratio;
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}
	
	
	
	//********************private data and methods********************

	private Ratio_Point ratio;
	private BufferedImage image;
}
