package ex4_example.robot_for_gui;

import Coords.GeoBox;
import Coords.LatLonAlt;

public class B extends GeoBox {

    public B(LatLonAlt p1, LatLonAlt p2) {
        super(p1, p2);
    }

    public B(String line) {
        super(line);
    }

    public B(GeoBox geoBox) {
        super(geoBox);
    }
}
