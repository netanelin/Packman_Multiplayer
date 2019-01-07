package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JFrame;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import Algo.Path;
import Coords.Cords;
import Coords.LatLonAlt;
import Game_Components.Box;
import Game_Components.Element;
import Game_Components.Fruit;
import Game_Components.Game;
import Game_Components.Ghost;
import Game_Components.Map;
import Game_Components.Me_player;
import Game_Components.Packman;
import Ratio.Ratio_Point;
import Robot.Play;
import Algo.Algorithm;

public class Main_Window extends JFrame implements MouseListener, MenuListener {

	private static final long serialVersionUID = -4858247425376916779L;
	BufferedImage myImage=null;
	private String game_status;
	private Play play;
	private Map map;
	private Game game;
	private ArrayList<String> board_data;
	private String info;
	private Point pixel_location;
	private final Lock lock = new ReentrantLock();

	public Main_Window() 
	{
		initGUI();
		this.addMouseListener(this); 
	}


	private void initGUI() 
	{
		initMENU();
		map= new Map(new Coords.LatLonAlt(32.101898,35.202369,0.0), new Coords.LatLonAlt(32.105728,35.212416,0.0));
		game = new Game(map);
		myImage = game.getMap().getMyImage();
		game_status = "nothing";
		board_data = new ArrayList<String>();
		pixel_location = new Point();
		info = new String();
	}


	private void initMENU() {

		MenuBar menuBar = new MenuBar();

		Menu Choose_senerio = new Menu("Choose senerio");
		Menu run = new Menu("Run");
		Menu clear_all = new Menu("Clear");

		MenuItem senerio_1 = new MenuItem("senerio_1");
		senerio_1(senerio_1);
		MenuItem senerio_2 = new MenuItem("senerio_2");
		senerio_2(senerio_2);
		MenuItem senerio_3 = new MenuItem("senerio_3");
		senerio_3(senerio_3);
		MenuItem senerio_4 = new MenuItem("senerio_4");
		senerio_4(senerio_4);
		MenuItem senerio_5 = new MenuItem("senerio_5");
		senerio_5(senerio_5);
		MenuItem senerio_6 = new MenuItem("senerio_6");
		senerio_6(senerio_6);
		MenuItem senerio_7 = new MenuItem("senerio_7");
		senerio_7(senerio_7);
		MenuItem senerio_8 = new MenuItem("senerio_8");
		senerio_8(senerio_8);
		MenuItem senerio_9 = new MenuItem("senerio_9");
		senerio_9(senerio_9);

		MenuItem run_manual = new MenuItem("run manual");
		run_manual(run_manual);
		MenuItem run_algorithm = new MenuItem("run algorithm");
		run_algorithm(run_algorithm);

		MenuItem clear = new MenuItem("clear");
		clear(clear);

		menuBar.add(Choose_senerio);
		menuBar.add(run);
		menuBar.add(clear_all);

		Choose_senerio.add(senerio_1);
		Choose_senerio.add(senerio_2);
		Choose_senerio.add(senerio_3);
		Choose_senerio.add(senerio_4);
		Choose_senerio.add(senerio_5);
		Choose_senerio.add(senerio_6);
		Choose_senerio.add(senerio_7);
		Choose_senerio.add(senerio_8);
		Choose_senerio.add(senerio_9);

		run.add(run_manual);
		run.add(run_algorithm);

		clear_all.add(clear);

		this.setMenuBar(menuBar);
	}

	private void clear(){
		board_data.clear();
		game.clearAll();
		play = null;
	}

	private void clear(MenuItem clear) {
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					lock.lock();
					game_status = "nothing";
					clear();
					repaint();
				} finally {
					lock.unlock();
				}	
			}
		});		
	}


	private void update_board_data() {
		try {
			lock.lock();
			game.clearAll();
			board_data.clear();
			board_data = play.getBoard();
			for(int i=0;i<board_data.size();i++) {
				if(board_data.get(i).charAt(0)=='B') {
					game.addBox(new Box(board_data.get(i), map));
				}
				else {
					game.addElement(get_element(board_data.get(i), map));
				}
			}
		} finally {
			lock.unlock();
		}
	}


	private Element get_element(String line, Map map) {
		char type = line.charAt(0);
		if(type == 'M')
			return new Me_player(line, map);
		else if(type == 'P')
			return new Packman(line, map);
		else if(type == 'F')
			return new Fruit(line, map);
		else if(type == 'G')
			return new Ghost(line, map);

		return null;
	}


	private void senerio_update(String input) {
		game_status ="senerio_active"; 
		game.clearAll();
		String file_name = input;
		play = new Play(file_name);
		play.setIDs(205463920,311300784);
		update_board_data();
		repaint();
	}



	private void senerio_1(MenuItem senerio_1) {
		senerio_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example1.csv");
			}
		});		
	}


	private void senerio_2(MenuItem senerio_2) {
		senerio_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example2.csv");
			}			
		});				
	}


	private void senerio_3(MenuItem senerio_3) {
		senerio_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example3.csv");
			}
		});				
	}


	private void senerio_4(MenuItem senerio_4) {
		senerio_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example4.csv");
			}
		});				
	}


	private void senerio_5(MenuItem senerio_5) {
		senerio_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example5.csv");
			}
		});				
	}


	private void senerio_6(MenuItem senerio_6) {
		senerio_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example6.csv");
			}
		});				
	}


	private void senerio_7(MenuItem senerio_7) {
		senerio_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example7.csv");
			}
		});				
	}


	private void senerio_8(MenuItem senerio_8) {
		senerio_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example8.csv");
			}
		});				
	}


	private void senerio_9(MenuItem senerio_9) {
		senerio_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example9.csv");
			}
		});				
	}


	private void run_manual(MenuItem run_manual) {
		run_manual.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(game_status.equals("senerio_active"))
					game_status = "run_game_manual";
			}

		});		
	}


	private void run_algorithm(MenuItem run_algorithm) {
		run_algorithm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(game_status.equals("senerio_active")) {
					game_status = "run_game_algo";
					algo_Thread();
				}
			}
		});		
	}




	private void algo_Thread() {

		new Thread() {
			public void run() {
				if(game_status.equals("run_game_algo")) {
					LatLonAlt gps_location = null;
					boolean found_fruit = false;
					for(int i = 0; i < game.getElement_List().size() && !found_fruit; i++) {
						if(game.getElement_List().get(i) instanceof Fruit) {
							gps_location = game.getElement_List().get(i).getRatio().to_latLon(map);
							found_fruit = true;
						}
					}
					play.setInitLocation(gps_location.lat(),gps_location.lon());
					play.start();
					info = play.getStatistics();
					System.out.println(info);
					update_board_data();
					repaint();

					while(game_status.equals("run_game_algo") && game.getElements().fruits_left() && time_left()){
						Path path = Algorithm.run(game);
						for(LatLonAlt gps_point : path.getPoints()){
							boolean arrived = false;
							while(game_status.equals("run_game_algo") &&
									!arrived && game.getElements().fruits_left() && time_left()){
								Point p = new Ratio_Point(gps_point, map).to_pixels(getWidth(), getHeight());
								move_game_pieces(p.x, p.y);
								try {
									Thread.sleep(35);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
								if(game_status.equals("run_game_algo") &&
										gps_point.GPS_distance(game.getElements().get_me_location().to_latLon(map))<=1) {
//										&& fruit_still_exist(path.getPoints().get(path.getPoints().size()-1))) {
									arrived = true;
								}
							}
						}
					}
					if(game_status.equals("run_game_algo")) {
						try {
							lock.lock();
							move_game_pieces(0, 0);
						} finally {
							lock.unlock();
						}
						game_status = "nothing";
						info = play.getStatistics();
						play.stop();
						System.out.println("**** Game Over! ****\n" + "End game: " + info);
						clear();
						repaint();
					}
				}
			}
		}.start();
	}


//private boolean fruit_still_exist(LatLonAlt fruit_location) {
//	for (Element element : game.getElement_List()) {
////		System.out.println(element.getRatio().to_latLon(game.getMap())+"  "+fruit_location);
//		LatLonAlt ele = element.getRatio().to_latLon(game.getMap());
//		if(element instanceof Fruit && ele.lat()==fruit_location.lat() && 
//				ele.lon()==fruit_location.lon()&&
//				ele.alt()==fruit_location.alt()) {
//			return true;
//		}
//	}
//	return false;
//}


	public void paint(Graphics g){
		g.drawImage(myImage, 0, 0,getWidth()-8,getHeight()-8, this);

		try {
			lock.lock();
			for(Box box: game.getBox_List()) {
				Point minPixels = box.getBottom_left().to_pixels(getWidth(), getHeight());
				Point maxPixels = box.getTop_right().to_pixels(getWidth(), getHeight());

				g.setColor(Color.BLACK);
				int rectWidth = maxPixels.x-minPixels.x;
				int rectHeight = minPixels.y-maxPixels.y;
				g.fillRect(minPixels.x, maxPixels.y, rectWidth, rectHeight);
			}

			for(Element element: game.getElement_List()) {
				Point Pixels = element.getRatio().to_pixels(getWidth(), getHeight());
				g.drawImage(element.getImage(), Pixels.x-8, Pixels.y-8, getWidth()/50, getHeight()/25, this);
			}
		} finally {
			lock.unlock();
		}
	}


	@Override
	public void menuCanceled(MenuEvent arg0) {
	}

	@Override
	public void menuDeselected(MenuEvent arg0) {
	}

	@Override
	public void menuSelected(MenuEvent arg0) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if(game_status.equals("run_game_manual")) {
			Ratio_Point location = new Ratio_Point(new Point(e.getX(),e.getY()), getWidth(), getHeight());
			if(!game.getBoxes().is_in_boxes(location)) {
				LatLonAlt gps_location = location.to_latLon(map);
				play.setInitLocation(gps_location.lat(),gps_location.lon());
				play.start();
				info = play.getStatistics();
				System.out.println(info);
				update_board_data();
				repaint();
				game_status = "location_initiated";
			}
		}
	}


	private boolean time_left() {
		String[] data = info.split(",");
		String time_string = data[3].substring(data[3].indexOf(':')+1);
		double time = Double.parseDouble(time_string);
		return time>100;
	}


	private void move_game_pieces(int x, int y) {
		pixel_location = game.getElements().get_me_location().to_pixels(getWidth(), getHeight());
		double angle = Cords.angXY(x-pixel_location.x, pixel_location.y-y);
		play.rotate(angle);
		info = play.getStatistics();
		System.out.println(info);
		update_board_data();
		repaint();		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	volatile private boolean mouseDown = false;

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			mouseDown = true;
			manual_Thread(e.getX(),e.getY());
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			mouseDown = false;
		}
	}

	volatile private boolean isRunning = false;
	private synchronized boolean checkAndMark() {
		if (isRunning) return false;
		isRunning = true;
		return true;
	}
	private void manual_Thread(int x, int y) {
		if (checkAndMark()) {
			new Thread() {
				public void run() {
					do {
						if(game_status.equals("location_initiated")) {
							if(game.getElements().fruits_left() && time_left()) {
								move_game_pieces(x, y);
								try {
									Thread.sleep(35);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
							else {
								try {
									lock.lock();
									move_game_pieces(x, y);
								} finally {
									lock.unlock();
								}
								game_status = "nothing";
								info = play.getStatistics();
								play.stop();
								System.out.println("**** Game Over! ****\n" + "End game: " + info);
								clear();
								repaint();
							}
						}
					} while (mouseDown);
					isRunning = false;
				}
			}.start();
		}
	}
}
