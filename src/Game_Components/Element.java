package Game_Components;

import java.awt.image.BufferedImage;

import Ratio.Ratio_Point;

/**
 * This interface represents a general element that contains a Ratio_Point location and BufferedImage.
 * @author Eitan Lichtman, Netanel Indik
 */
public interface Element {
	/**
	 * @return elements Ratio_Point.
	 */
	public Ratio_Point getRatio();

	/**
	 * 
	 * @return elements BufferedImage.
	 */
	public BufferedImage getImage();
}
