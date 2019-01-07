package Ratio;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import Coords.LatLonAlt;
import Game_Components.Map;

class Ratio_PointTest {


	@Test
	void test_to_latLon() {
		LatLonAlt min = new LatLonAlt(32.10190,35.20236,0);
		LatLonAlt max = new LatLonAlt(32.10582,35.21234,0);
		Map map = new Map(min, max);

		Ratio_Point rp = new Ratio_Point(new Point(300,200), 600, 400);

		LatLonAlt expected = new LatLonAlt(32.10386,35.20735,0.0);
		assertTrue(rp.to_latLon(map).equals(expected));
	}
	
	@Test
	void test_to_pixels() {
		LatLonAlt min = new LatLonAlt(32.10190,35.20236,0);
		LatLonAlt max = new LatLonAlt(32.10582,35.21234,0);
		Map map = new Map(min, max);

		Ratio_Point rp = new Ratio_Point(new LatLonAlt(32.10386,35.20735,0.0), map);

		Point expected = new Point(300,200);
		assertTrue(rp.to_pixels(600, 400).equals(expected));
	}

}
