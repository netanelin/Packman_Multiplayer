package Game_Components;

import java.util.ArrayList;

import Ratio.Ratio_Point;
import Ratio.Ratio_Segment;

/**
 * This class represents a list of black boxes.
 * @author Eitan Lichtman, Netanel Indik
 */
public class Boxes {
	
	
	/**
	 * Initiates the box_list ArrayList.
	 */
	public Boxes() {
		box_list = new ArrayList<Box>();
	}
	
	/**
	 * Adds a given box to our list.
	 * @param box
	 */
	public void add(Box box) {
		box_list.add(box);
	}
	
	/**
	 * Clears our box list.
	 */
	public void clear() {
		box_list.clear();
	}

	public ArrayList<Box> getBox_list() {
		return box_list;
	}
	
	/**
	 * @param ratio
	 * @return true iff a given Ratio_Point is in one of our boxes.
	 */
	public boolean is_in_boxes(Ratio_Point ratio) {
		for(Box box : box_list) {
			if(box.is_in_box(ratio))
				return true;
		}
		return false;
	}
	
	/**
	 * @param seg
	 * @return true iff a given Ratio_Segment intersects with one of our boxes.
	 */
	public boolean intersect(Ratio_Segment seg) {
		for(Box box : box_list) {
			if(box.intersect(seg))
				return true;
		}
		return false;
	}

	
	
	//********************private data and methods********************
	
	private ArrayList<Box> box_list;

}
