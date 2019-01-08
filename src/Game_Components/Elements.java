package Game_Components;

import java.util.ArrayList;

import Ratio.Ratio_Point;

/**
 * This class represents a list of elements.
 * @author Eitan Lichtman, Netanel Indik
 */
public class Elements {
	
	/**
	 * Initiates the element_list ArrayList
	 */
	public Elements() {
		element_list = new ArrayList<Element>();
	}
	
	/**
	 * Adds a given element to our list.
	 * @param element
	 */
	public void add(Element element) {
		element_list.add(element);
	}
	
	/**
	 * Clears our element list.
	 */
	public void clear() {
		element_list.clear();
	}

	public ArrayList<Element> getElement_list() {
		return element_list;
	}
	
	/**
	 * @return true iff there are fruits left in our list of elements.
	 */
	public boolean fruits_left() {
		boolean fruits_left = false;

			for(Element element: element_list) {
				if(element instanceof Fruit)
					fruits_left = true;
			}
		return fruits_left;
	}
	
	/**
	 * @return true iff there are Packmans in our list of elements.
	 */
	public boolean contains_packmans() {
		boolean contains_packmans = false;

			for(Element element: element_list) {
				if(element instanceof Packman)
					contains_packmans = true;
			}
		return contains_packmans;
	}

	/**
	 * @return Me_player location.
	 */
	public Ratio_Point get_me_location(){

		for(Element element: element_list) {
			if(element instanceof Me_player)
				return element.getRatio();
		}
		return null;
	}
	
	
	
	//********************private data and methods********************

	private ArrayList<Element> element_list;
	
}
