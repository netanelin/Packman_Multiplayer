package Game_Components;

import Ratio.Ratio_Point;

import java.util.ArrayList;
import java.util.Iterator;

public class Game {

	private Map map;
	private Element_List elements;
	private Box_List boxes;

	public Game(Map m) {
		map = new Map(m.getMin(), m.getMax());
		elements = new Element_List();
		boxes = new Box_List();
	}
	
	public Game(Game ot) {
		map = new Map(ot.map);
		for(Element element: ot.elements.getElements()) {
			elements.add(element);
		}
		for(Box box: ot.boxes.getBoxes()) {
			boxes.add(box);
		}
	}

	public void addElement(Element element) {
		elements.add(element);
	}
	
	public void addBox(Box box) {
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
	
	public Map getMap() {
		return map;
	}

	public ArrayList<Element> getElement_List() {
		return elements.getElements();
	}

	public ArrayList<Box> getBox_List() {
		return boxes.getBoxes();
	}

	public Element_List getElements() {
		return elements;
	}

	public Box_List getBoxes() {
		return boxes;
	}

	
	
}