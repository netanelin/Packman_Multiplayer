package Algo;

import java.util.ArrayList;

import Coords.LatLonAlt;

public class Path {

	private ArrayList<LatLonAlt> points;

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

	public Path(LatLonAlt fruit_location){
		points = new ArrayList<LatLonAlt>();
		points.add(fruit_location);
	}

	public ArrayList<LatLonAlt> getPoints() {
		return points;
	}
}
