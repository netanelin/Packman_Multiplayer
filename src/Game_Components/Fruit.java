package Game_Components;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Ratio.Ratio_Point;

/**
 * This class represents a single fruit with a Ratio_point location and BufferedImage.
 * @author Eitan Lichtman, Netanel Indik
 *
 */
public class Fruit implements Element{

	/**
	 * Initiates the fruit by a given line from csv file.
	 * @param line
	 * @param map
	 */
	public Fruit (String line, Map map){
		String[] data = line.split(",");
		Coords.LatLonAlt gps_point = new Coords.LatLonAlt(Double.parseDouble(data[2]),Double.parseDouble(data[3]),0);

		ratio = new Ratio_Point(gps_point , map);

		try {
			image = ImageIO.read(new File("Images\\3d_strawberry.png"));
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
