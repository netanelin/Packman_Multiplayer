package Game_Elements;

import java.awt.image.BufferedImage;

import Ratio.Ratio_point;

public interface Element {
		
	public Ratio_point getRatio();
	
	public BufferedImage getImage();
}
