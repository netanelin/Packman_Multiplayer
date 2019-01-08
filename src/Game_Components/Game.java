package Game_Components;

import java.util.ArrayList;

import Ratio.Ratio_Point;

public class Game {

	private Map map;
	private Elements elements;
	private Boxes boxes;

	public Game(Map m) {
		map = new Map(m.getMin(), m.getMax());
		elements = new Elements();
		boxes = new Boxes();
	}
	
	public Game(Game ot) {
		map = new Map(ot.map);
		for(Element element: ot.elements.getElement_list()) {
			elements.add(element);
		}
		for(Box box: ot.boxes.getBox_list()) {
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
		return elements.getElement_list();
	}

	public ArrayList<Box> getBox_List() {
		return boxes.getBox_list();
	}

	public Elements getElements() {
		return elements;
	}

	public Boxes getBoxes() {
		return boxes;
	}

	public boolean fruits_left() {
		return elements.fruits_left();
	}
	
	public Ratio_Point get_me_location(){
		return elements.get_me_location();
	}
}