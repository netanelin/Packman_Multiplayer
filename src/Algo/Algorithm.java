package Algo;

import Coords.Cords;
import Coords.LatLonAlt;
import Game_Components.*;
import Geom.Point3D;
import Ratio.Ratio_Point;
import Ratio.Ratio_Segment;
import graph.Graph;
import graph.Graph_Algo;
import graph.Node;

import java.util.ArrayList;

public class Algorithm {

    public static Path run(Game game){

    	Fruit closest_fruit = null;
    	Path shortest_path = null;
    	double min_distance = Double.MAX_VALUE;

        for(Element element : game.getElement_List())
            if(element instanceof Fruit){
                //TODO write the diagstra algo
                //האם יש קן ישיר לפרי
               Ratio_Segment seg = new Ratio_Segment( game.getElements().get_me_location(), element.getRatio());
                if(!game.getBoxes().intersect(seg)){
                    LatLonAlt me = game.getElements().get_me_location().to_latLon(game.getMap());
                    LatLonAlt fruit = element.getRatio().to_latLon(game.getMap());
                    if(me.distance2D(fruit)<min_distance){
                        closest_fruit = (Fruit)element;
                        shortest_path = new Path(fruit);
                        min_distance = me.distance2D(fruit);
                    }
                }
                //אין קו ישר אז בונים מסלול בעזרת דיאגסטרה
                else{
                    ArrayList<LatLonAlt> graph_list = new ArrayList<>();
                    graph_list.add(game.getElements().get_me_location().to_latLon(game.getMap()));
                    graph_list.addAll(shifted_corners(game));
                    graph_list.add(element.getRatio().to_latLon(game.getMap()));

                    Graph G = new Graph();
                    String source = "M";
                    String target = "F";
                    G.add(new Node(source));
                    for(int i=1;i<graph_list.size()-1;i++) {
                        Node d = new Node("" + i);
                        G.add(d);
                    }
                    G.add(new Node(target));

                    for (int i = 0; i < graph_list.size()-1; i++) {
                        for (int j = i+1; j < graph_list.size(); j++){
                            if(clear_sight(graph_list.get(i), graph_list.get(j), game)){
                                double dist = graph_list.get(i).distance2D(graph_list.get(j));
                                if(i==0){
                                    G.addEdge("M",""+j,dist);
                                }
                                else if(j==graph_list.size()-1) {
                                    G.addEdge("" + i, "F", dist);
                                }
                                else{
                                    G.addEdge("" + i,""+j,dist);
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
        return shortest_path;
    }

    private static ArrayList<LatLonAlt> shifted_corners(Game game){

        ArrayList<LatLonAlt> uncontained_corners = new ArrayList<>();
        for (Box box_i: game.getBox_List()) {
            boolean top_right_check = false;
            boolean top_left_check = false;
            boolean bottom_right_check = false;
            boolean bottom_left_check = false;
            for (Box box_j: game.getBox_List()) {
                if(box_i!=box_j) {
                    if(box_j.is_in_box(box_i.getTop_right()))
                        top_right_check = true;
                    if(box_j.is_in_box(box_i.getTop_left()))
                        top_left_check =true;
                    if(box_j.is_in_box(box_i.getBottom_right()))
                        bottom_right_check =true;
                    if(box_j.is_in_box(box_i.getBottom_left()))
                        bottom_left_check =true;
                }
            }
            if(!top_right_check) {
                LatLonAlt corner1 = box_i.getTop_right().to_latLon(game.getMap());
                LatLonAlt shifted_corner1 = corner1.tanstale(new Point3D(1, 1, 0));
                uncontained_corners.add(shifted_corner1);
            }
            if(!top_left_check) {
                LatLonAlt corner2 = box_i.getTop_right().to_latLon(game.getMap());
                LatLonAlt shifted_corner2 = corner2.tanstale(new Point3D(1, -1, 0));
                uncontained_corners.add(shifted_corner2);
            }
            if(!bottom_right_check){
                LatLonAlt corner3 = box_i.getTop_right().to_latLon(game.getMap());
                LatLonAlt shifted_corner3 = corner3.tanstale(new Point3D(-1, 1, 0));
                uncontained_corners.add(shifted_corner3);
            }
            if(!bottom_left_check){
                LatLonAlt corner4 = box_i.getTop_right().to_latLon(game.getMap());
                LatLonAlt shifted_corner4 = corner4.tanstale(new Point3D(-1, -1, 0));
                uncontained_corners.add(shifted_corner4);
            }
        }
        return uncontained_corners;
    }

    private static boolean clear_sight(LatLonAlt p1, LatLonAlt p2, Game game ){
        Ratio_Point rp1 = new Ratio_Point(p1,game.getMap());
        Ratio_Point rp2 = new Ratio_Point(p2,game.getMap());
        Ratio_Segment rs = new Ratio_Segment(rp1,rp2);
        return !game.getBoxes().intersect(rs);
    }
}
