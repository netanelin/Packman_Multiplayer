package ex4_example.robot_for_gui;

import Coords.LatLonAlt;
import Robot.Packman;

public class G extends Packman {
    public G(LatLonAlt start, double speed) {
        super(start, speed);
    }

    public G(String line) {
        super(line);
    }

    public G(G g) {
        super(g.toString2());
    }
}
