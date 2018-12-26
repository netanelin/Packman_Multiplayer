package robot_for_gui;

import Coords.LatLonAlt;
import Robot.Packman;

public class M extends Packman {
    public M(LatLonAlt start, double speed) {
        super(start, speed);
    }

    public M(String line) {
        super(line);
    }

    public M(M m) {
        super(m.toString1());
    }
}
