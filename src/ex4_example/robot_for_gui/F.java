package ex4_example.robot_for_gui;

import Coords.LatLonAlt;
import Robot.Fruit;

public class F extends Fruit {

    public F(LatLonAlt start) {
        super(start);
    }

    public F(String line) {
        super(line);
    }

    public F(Fruit fruit) {
        super(fruit);
    }
}
