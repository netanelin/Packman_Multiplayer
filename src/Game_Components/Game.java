package Game_Components;

import java.util.ArrayList;

import Ratio.Ratio_Point;

/**
 * This class represents a full game including a map, elements and boxes.
 * @author Eitan Lichtman, Netanel Indik
 */
public class Game {

	/**
	 * Initiates game by given map.
	 * @param m
	 */
	public Game(Map m) {
		map = new Map(m.getMin(), m.getMax());
		elements = new Elements();
		boxes = new Boxes();
	}
	
	/**
	 * Adds a given element to our game.
	 * @param element
	 */
	public void addElement(Element element) {
		elements.add(element);
	}

	/**
	 * Adds a given box to our game.
	 * @param element
	 */
	public void addBox(Box box) {
		boxes.add(box);
	}

	/**
	 * Clears elements from our game.
	 */
	public void clearElements() {
		elements.clear();
	}

	/**
	 * Clears boxes from our game.
	 */
	public void clearBoxes() {
		boxes.clear();
	}

	/**
	 * Clears elements and boxes from our game.
	 */
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

	/**
	 * @return true iff there are fruits left in our game.
	 */
	public boolean fruits_left() {
		return elements.fruits_left();
	}

	/**
	 * @return true iff there are Packmans in our game.
	 */
	public boolean contains_packmans() {
		return elements.contains_packmans();
	}

	/**
	 * @return Me_player location.
	 */
	public Ratio_Point get_me_location(){
		return elements.get_me_location();
	}



	//********************private data and methods********************

	private Map map;
	private Elements elements;
	private Boxes boxes;
}