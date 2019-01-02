package Game_Components;

import java.util.ArrayList;

import Ratio.Ratio_Point;

public class Elements {
	
	private ArrayList<Element> element_list;
	
	public Elements() {
		element_list = new ArrayList<Element>();
	}
	
	public void add(Element element) {
		element_list.add(element);
	}
	
	public void clear() {
		element_list.clear();
	}

	public ArrayList<Element> getElement_list() {
		return element_list;
	}
	
	public boolean fruits_left() {
		boolean fruits_left = false;

			for(Element element: element_list) {
				if(element instanceof Fruit)
					fruits_left = true;
			}

		return fruits_left;
	}

	public Ratio_Point get_me_location(){

		for(Element element: element_list) {
			if(element instanceof Me_player)
				return element.getRatio();
		}
		return null;
	}
	
}
