package Game_Elements;

import Ratio.Ratio_point;

import java.util.ArrayList;

public class Game {

	private Map map;
	private ArrayList<Element> elements;
	private ArrayList<Box> boxes;

	public Game(Map m) {
		map = new Map(m.getMin(), m.getMax());
		elements = new ArrayList<Element>();
		boxes = new ArrayList<Box>();
	}
	
	public Game(Game ot) {
		map = new Map(ot.map);
		for(Element element: ot.elements) {
			elements.add(element);
		}
		for(Box box: ot.boxes) {
			boxes.add(box);
		}
	}

	public boolean fruits_left() {
		boolean fruits_left = false;

			for(Element element: elements) {
				if(element instanceof Fruit)
					fruits_left = true;
			}

		return fruits_left;
	}

	public Ratio_point get_me_location(){

		for(Element element: elements) {
			if(element instanceof Me_player)
				return element.getRatio();
		}
		return null;
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

	public ArrayList<Element> getElements() {
		return elements;
	}

	public ArrayList<Box> getBoxes() {
		return boxes;
	}

}