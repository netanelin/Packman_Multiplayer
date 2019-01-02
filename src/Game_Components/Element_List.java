package Game_Components;

import java.util.ArrayList;
import java.util.Iterator;

import Ratio.Ratio_Point;

public class Element_List {
	
	private ArrayList<Element> elements;
	
	public Element_List() {
		elements = new ArrayList<Element>();
	}
	
	public void add(Element element) {
		elements.add(element);
	}
	
	public void clear() {
		elements.clear();
	}

	public ArrayList<Element> getElements() {
		return elements;
	}
	
	public boolean fruits_left() {
		boolean fruits_left = false;

			for(Element element: elements) {
				if(element instanceof Fruit)
					fruits_left = true;
			}

		return fruits_left;
	}

	public Ratio_Point get_me_location(){

		for(Element element: elements) {
			if(element instanceof Me_player)
				return element.getRatio();
		}
		return null;
	}
	
	public Iterator<Element> iterator(){
		return elements.iterator();
	}
}
