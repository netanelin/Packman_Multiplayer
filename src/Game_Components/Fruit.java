package Game_Components;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Ratio.Ratio_Point;

public class Fruit implements Element{
	
	private Ratio_Point ratio;
	private BufferedImage image;
	
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
}
