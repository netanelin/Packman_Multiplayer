package robot_for_gui;

import Coords.LatLonAlt;
import Robot.Packman;

public class P extends Packman {
    public P(LatLonAlt start, double speed) {
        super(start, speed);
    }

    public P(String line) {
        super(line);
    }

    public P(P p) {
        super(p);
    }
}
