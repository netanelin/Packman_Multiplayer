package Game_Elements;

import java.awt.image.BufferedImage;

import Ratio.Ratio_Point;

public interface Element {
		
	public Ratio_Point getRatio();
	
	public BufferedImage getImage();
}
