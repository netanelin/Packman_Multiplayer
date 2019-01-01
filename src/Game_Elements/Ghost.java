package Game_Elements;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Coords.LatLonAlt;
import Ratio.Ratio_Point;

public class Ghost implements Element{
	
//	private char element_type;
	private Ratio_Point ratio;
	private BufferedImage image;
	
	public Ghost (String line, Map map){
		 String[] data = line.split(",");
//	        element_type = data[0].charAt(0);
	       LatLonAlt gps_point = new LatLonAlt(Double.parseDouble(data[2]),Double.parseDouble(data[3]),0);
	       
			ratio = new Ratio_Point(gps_point , map);
			
			try {
				image = ImageIO.read(new File("Images\\ghost.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}	
			
	}

//	@Override
//	public char getElement_type() {
//		// TODO Auto-generated method stub
//		return element_type;
//	}

	@Override
	public Ratio_Point getRatio() {
		// TODO Auto-generated method stub
		return ratio;
	}

	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return image;
	}
	
}
