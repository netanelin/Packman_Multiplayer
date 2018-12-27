package Game_Elements_For_Gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game_Elements.Element;

public class Gui_Element {

	private char element_type;
	private Ratio ratio;
	private BufferedImage image;

	public Gui_Element (Element element, Gui_Map map){
		element_type = element.getElement_type();
		ratio = new Ratio(element.getGps_point(), map);

		if(element_type=='P') {
			try {
				image = ImageIO.read(new File("Images\\pacman_right.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		else if(element_type=='M') {
			try {
				image = ImageIO.read(new File("Images\\pacman_left.png"));
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

	
	
	public Gui_Element (String line, Gui_Map map){
	this(new Element(line), map);
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
