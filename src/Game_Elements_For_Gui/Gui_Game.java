package Game_Elements_For_Gui;

import java.util.ArrayList;

public class Gui_Game {

	private Gui_Map map;
	private ArrayList<Gui_Element> elements;
	private ArrayList<Gui_Box> boxes;

	public Gui_Game(Gui_Map m) {
		map = new Gui_Map(m.getMin(), m.getMax());
		elements = new ArrayList<Gui_Element>();
		boxes = new ArrayList<Gui_Box>();
	}
	
	public void addElement(Gui_Element element) {
		elements.add(element);
	}
	
	public void addBox(Gui_Box box) {
		boxes.add(box);
	}
	
	public void clearElements() {
		elements.clear();
	}

	
	public void clearBoxes() {
		boxes.clear();
	}
	
	
	public void clearAll() {
		elements.clear();
		boxes.clear();
	}
	
	public Gui_Map getMap() {
		return map;
	}

	public ArrayList<Gui_Element> getElements() {
		return elements;
	}

	public ArrayList<Gui_Box> getBoxes() {
		return boxes;
	}

	
	
	
}