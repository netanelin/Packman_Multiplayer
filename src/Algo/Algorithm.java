package Algo;

import Coords.LatLonAlt;
import Game_Components.*;
import Geom.Point3D;
import Ratio.Ratio_Point;
import Ratio.Ratio_Segment;
import graph.Graph;
import graph.Graph_Algo;
import graph.Node;

import java.util.ArrayList;
/**
 * This class has a static method that calculates the shortest path to the next fruit.
 * @author Eitan Lichtman, Netanel Indik
 */
public class Algorithm {
	
	/**
	 * Calculates the shortest path to the next fruit using dijkstra algorithm and returns the path.
	 * @param game
	 * @return Path
	 */
	public static Path run(Game game){

		Fruit closest_fruit = null;
		Path shortest_path = null;
		double min_distance = Double.MAX_VALUE;

		for(Element element : game.getElement_List()) {
			if(element instanceof Fruit){
				Ratio_Segment seg = new Ratio_Segment(game.getElements().get_me_location(), element.getRatio());
				if(!game.getBoxes().intersect(seg)){
					LatLonAlt me = game.getElements().get_me_location().to_latLon(game.getMap());
					LatLonAlt fruit = element.getRatio().to_latLon(game.getMap());
					if(me.GPS_distance(fruit)<min_distance){
						closest_fruit = (Fruit)element;
						shortest_path = new Path(fruit);
						min_distance = me.GPS_distance(fruit);
					}
				}
				else{
					ArrayList<LatLonAlt> graph_list = new ArrayList<>();
					graph_list.add(game.getElements().get_me_location().to_latLon(game.getMap()));
					graph_list.addAll(shifted_corners(game));
					graph_list.add(element.getRatio().to_latLon(game.getMap()));

					Graph G = new Graph();
					String source = "a";
					String target = "b";
					G.add(new Node(source));
					for(int i=1;i<graph_list.size()-1;i++) {
						Node d = new Node("" + i);
						G.add(d);
					}
					G.add(new Node(target));

					for (int i = 0; i < graph_list.size()-1; i++) {
						for (int j = i+1; j < graph_list.size(); j++){
							if(clear_sight(graph_list.get(i), graph_list.get(j), game)){
								double dist = graph_list.get(i).GPS_distance(graph_list.get(j));
								if(i==0 && j==graph_list.size()-1) {
									G.addEdge("a","b",dist);
								}
								else if(i==0){
									G.addEdge("a",""+j,dist);
								}
								else if(j==graph_list.size()-1) {
									G.addEdge("" + i, "b", dist);
								}
								else{
									G.addEdge("" + i,""+j, dist);
								}
							}
						}
					}
					Graph_Algo.dijkstra(G, source);
					Node b = G.getNodeByName(target);
					if(b.getDist()<min_distance){
						closest_fruit = (Fruit)element;
						shortest_path = new Path(b.getPath(), graph_list);
						min_distance = b.getDist();
					}
				}
			}
		}
		return shortest_path;
	}
	
	
	
	//********************private data and methods********************
	
	/**
	 * Returns an ArrayList of LatLonAlt points that represent the box corners shifted a little.
	 * @param game
	 * @return ArrayList<LatLonAlt> shifted_corners
	 */
	private static ArrayList<LatLonAlt> shifted_corners(Game game){

		ArrayList<LatLonAlt> uncontained_corners = new ArrayList<>();
		for (Box box_i: game.getBox_List()) {
			
			LatLonAlt corner1 = box_i.getTop_right().to_latLon(game.getMap());
			LatLonAlt shifted_corner1 = corner1.tanstale(new Point3D(2, 2, 0));
			if(!game.getBoxes().is_in_boxes(new Ratio_Point(shifted_corner1, game.getMap()))) {
				uncontained_corners.add(shifted_corner1);
			}
			
			LatLonAlt corner2 = box_i.getTop_left().to_latLon(game.getMap());
			LatLonAlt shifted_corner2 = corner2.tanstale(new Point3D(-2, 2, 0));
			if(!game.getBoxes().is_in_boxes(new Ratio_Point(shifted_corner2, game.getMap()))) {
				uncontained_corners.add(shifted_corner2);
			}
			
			LatLonAlt corner3 = box_i.getBottom_right().to_latLon(game.getMap());
			LatLonAlt shifted_corner3 = corner3.tanstale(new Point3D(2, -2, 0));
			if(!game.getBoxes().is_in_boxes(new Ratio_Point(shifted_corner3, game.getMap()))) {
				uncontained_corners.add(shifted_corner3);
			}
			
			LatLonAlt corner4 = box_i.getBottom_left().to_latLon(game.getMap());
			LatLonAlt shifted_corner4 = corner4.tanstale(new Point3D(-2, -2, 0));
			if(!game.getBoxes().is_in_boxes(new Ratio_Point(shifted_corner4, game.getMap()))) {
				uncontained_corners.add(shifted_corner4);
			}	
		}
		return uncontained_corners;
	}

	/**
	 * Returns true iff there's a clear sight between the two LatLonAlt points.
	 * @param p1
	 * @param p2
	 * @param game
	 * @return true iff there's a clear sight between the two LatLonAlt points
	 */
	private static boolean clear_sight(LatLonAlt p1, LatLonAlt p2, Game game){
		Ratio_Point rp1 = new Ratio_Point(p1,game.getMap());
		Ratio_Point rp2 = new Ratio_Point(p2,game.getMap());
		Ratio_Segment rs = new Ratio_Segment(rp1,rp2);
		return !game.getBoxes().intersect(rs);
	}
}
