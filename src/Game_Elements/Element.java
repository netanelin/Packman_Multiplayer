package Game_Elements;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Coords.LatLonAlt;

public class Element {

	private char element_type;
	private Ratio ratio;
	private BufferedImage image;
	
	public Element (String line, Map map){
		 String[] data = line.split(",");
	        element_type = data[0].charAt(0);
	       LatLonAlt gps_point = new LatLonAlt(Double.parseDouble(data[2]),Double.parseDouble(data[3]),0);
	       
			ratio = new Ratio(gps_point , map);

			if(element_type=='P') {
				try {
					image = ImageIO.read(new File("Images\\packman.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
			else if(element_type=='M') {
				try {
					image = ImageIO.read(new File("Images\\Me_player.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
			else if(element_type=='G') {
				try {
					image = ImageIO.read(new File("Images\\ghost.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
			else if(element_type=='F') {
				try {
					image = ImageIO.read(new File("Images\\3d_cherry.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
	}

	
	
	public char getElement_type() {
		return element_type;
	}

	public Ratio getRatio() {
		return ratio;
	}



	public BufferedImage getImage() {
		return image;
	}

	
}
