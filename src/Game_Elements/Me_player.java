package Game_Elements;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Coords.LatLonAlt;
import Ratio.Ratio_Point;

public class Me_player implements Element{
	
	private Ratio_Point ratio;
	private BufferedImage image;
	
	public Me_player (String line, Map map){
		 String[] data = line.split(",");
	       LatLonAlt gps_point = new LatLonAlt(Double.parseDouble(data[2]),Double.parseDouble(data[3]),0);
	       
			ratio = new Ratio_Point(gps_point , map);
			
			try {
				image = ImageIO.read(new File("Images\\Me_player.png"));
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
