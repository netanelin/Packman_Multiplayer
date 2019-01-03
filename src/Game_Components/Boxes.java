package Game_Components;

import java.util.ArrayList;

import Ratio.Ratio_Point;
import Ratio.Ratio_Segment;

public class Boxes {
	
	private ArrayList<Box> box_list;
	
	public Boxes() {
		box_list = new ArrayList<Box>();
	}
	
	public void add(Box box) {
		box_list.add(box);
	}
	
	public void clear() {
		box_list.clear();
	}

	public ArrayList<Box> getBox_list() {
		return box_list;
	}
	
	public boolean is_in_boxes(Ratio_Point ratio) {
		for(Box box : box_list) {
			if(box.is_in_box(ratio))
				return true;
		}
		return false;
	}
	
	public boolean intersect(Ratio_Segment seg) {
		for(Box box : box_list) {
			if(box.intersect(seg))
				return true;
		}
		return false;
	}

	
}
