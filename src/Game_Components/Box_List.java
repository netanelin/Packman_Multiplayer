package Game_Components;

import java.util.ArrayList;
import java.util.Iterator;

public class Box_List {
	
	private ArrayList<Box> boxes;
	
	public Box_List() {
		boxes = new ArrayList<Box>();
	}
	
	public void add(Box box) {
		boxes.add(box);
	}
	
	public void clear() {
		boxes.clear();
	}

	public ArrayList<Box> getBoxes() {
		return boxes;
	}
	
	public Iterator<Box> iterator(){
		return boxes.iterator();
	}
}
