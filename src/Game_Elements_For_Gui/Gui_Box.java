package Game_Elements_For_Gui;

import Coords.LatLonAlt;
import Game_Elements.Box;

public class Gui_Box {

	private Ratio min_ratio;
	private Ratio max_ratio;

	public Gui_Box(Box box, Gui_Map map) {
		min_ratio = new Ratio(box.getMin(), map);
		max_ratio = new Ratio(box.getMax(), map);
	}
	
	public Gui_Box(String line, Gui_Map map){
		this(new Box(line), map);
    }

	public Ratio getMin_ratio() {
		return min_ratio;
	}

	public void setMin_ratio(Ratio min_ratio) {
		this.min_ratio = min_ratio;
	}

	public Ratio getMax_ratio() {
		return max_ratio;
	}

	public void setMax_ratio(Ratio max_ratio) {
		this.max_ratio = max_ratio;
	}
	
}
