package Algo;

import java.util.ArrayList;

import Coords.LatLonAlt;

/**
 * This class represents a path from the player to the next fruit.
 * @author Eitan Lichtman, Netanel Indik
 */
public class Path {

	/**
	 * Initiates path from given ArrayLists of graph nodes and LatLonAlt points.
	 * @param nodes
	 * @param locations
	 */
	public Path(ArrayList<String> nodes, ArrayList<LatLonAlt> locations){
		points = new ArrayList<LatLonAlt>();
		int index;
		for(String node_name : nodes){
			try {
				index = Integer.parseInt(node_name);
				points.add(locations.get(index));
			}catch(Exception e){
				}
		}
		points.add(locations.get(locations.size()-1));
	}

	/**
	 * Initiates path from given fruit_location (if there's a clear sight to the fruit).
	 * @param fruit_location
	 */
	public Path(LatLonAlt fruit_location){
		points = new ArrayList<LatLonAlt>();
		points.add(fruit_location);
	}

	
	public ArrayList<LatLonAlt> getPoints() {
		return points;
	}
	
	
	
	//********************private data and methods********************

	private ArrayList<LatLonAlt> points;

}
