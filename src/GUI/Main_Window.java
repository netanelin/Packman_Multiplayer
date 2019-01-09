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

/**
 * This is a GUI class that represents our whole game in graphics.
 * Including options to play one of nine senerios manualy or automaticly by running the algorithm.
 * @author Eitan Lichtman, Netanel Indik
 */
public class Main_Window extends JFrame implements MouseListener, MenuListener {

	BufferedImage myImage=null;

	/**
	 * Initiating our GUI main window.
	 */
	public Main_Window() 
	{
		initGUI();
		this.addMouseListener(this); 
	}

	/**
	 * Clears our game.
	 * @param clear
	 */
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

	/**
	 * Activates senerio_1 and updates our game.
	 * @param senerio_1
	 */
	private void senerio_1(MenuItem senerio_1) {
		senerio_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example1.csv");
				dbc.setGame_hash_code(2128259830);
			}
		});		
	}

	/**
	 * Activates senerio_2 and updates our game.
	 * @param senerio_2
	 */
	private void senerio_2(MenuItem senerio_2) {
		senerio_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example2.csv");
				dbc.setGame_hash_code(1149748017);
			}			
		});				
	}

	/**
	 * Activates senerio_3 and updates our game.
	 * @param senerio_3
	 */
	private void senerio_3(MenuItem senerio_3) {
		senerio_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example3.csv");
				dbc.setGame_hash_code(-683317070);
			}
		});				
	}

	/**
	 * Activates senerio_4 and updates our game.
	 * @param senerio_4
	 */
	private void senerio_4(MenuItem senerio_4) {
		senerio_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example4.csv");
				dbc.setGame_hash_code(1193961129);
			}
		});				
	}

	/**
	 * Activates senerio_5 and updates our game.
	 * @param senerio_5
	 */
	private void senerio_5(MenuItem senerio_5) {
		senerio_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example5.csv");
				dbc.setGame_hash_code(1577914705);
			}
		});				
	}

	/**
	 * Activates senerio_6 and updates our game.
	 * @param senerio_6
	 */
	private void senerio_6(MenuItem senerio_6) {
		senerio_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example6.csv");
				dbc.setGame_hash_code(-1315066918);
			}
		});				
	}

	/**
	 * Activates senerio_7 and updates our game.
	 * @param senerio_7
	 */
	private void senerio_7(MenuItem senerio_7) {
		senerio_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example7.csv");
				dbc.setGame_hash_code(-1377331871);
			}
		});				
	}

	/**
	 * Activates senerio_8 and updates our game.
	 * @param senerio_8
	 */
	private void senerio_8(MenuItem senerio_8) {
		senerio_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example8.csv");
				dbc.setGame_hash_code(552196504);
			}
		});				
	}

	/**
	 * Activates senerio_9 and updates our game.
	 * @param senerio_9
	 */
	private void senerio_9(MenuItem senerio_9) {
		senerio_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_update("data//Ex4_OOP_example9.csv");
				dbc.setGame_hash_code(919248096);
			}
		});				
	}

	/**
	 * Allows a person to play the current senerio manualy using the mouse.
	 * First click initiates the player, and then every time the mouse is pressed the player moves towards the mouse.
	 * @param run_manual
	 */
	private void run_manual(MenuItem run_manual) {
		run_manual.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(game_status.equals("senerio_active"))
					game_status = "run_game_manual";
			}

		});		
	}

	/**
	 * Runs the whole senerio using the algorithm.
	 * @param run_algorithm
	 */
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

	/**
	 * This is a Thread that runs through the whole algorith.
	 */
	private void algo_Thread() {

		new Thread() {
			public void run() {
				if(game_status.equals("run_game_algo")) {
					LatLonAlt gps_location = find_best_init_location();
					play.setInitLocation(gps_location.lat(),gps_location.lon());
					play.start();
					info = play.getStatistics();
					System.out.println(info);
					update_board_data();
					repaint();

					while(game_status.equals("run_game_algo") && game.fruits_left() && time_left()){
						Path path = Algorithm.run(game);
						for(LatLonAlt gps_point : path.getPoints()){
							boolean arrived = false;
							while(game_status.equals("run_game_algo") &&
									!arrived && game.fruits_left() && time_left()){
								Point p = new Ratio_Point(gps_point, map).to_pixels(getWidth(), getHeight());
								move_game_pieces(p.x, p.y);
								try {
									Thread.sleep(30);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
								if((game_status.equals("run_game_algo") &&
										gps_point.GPS_distance(game.get_me_location().to_latLon(map))<=2)
										|| !fruit_exists(path.getPoints().get(path.getPoints().size()-1))){
									arrived = true;
								}
							}
							if(!fruit_exists(path.getPoints().get(path.getPoints().size()-1)))
								break;
						}
					}
					if(game_status.equals("run_game_algo")) {
						game_status = "nothing";
						try {
							lock.lock();
							if(time_left())
								move_game_pieces(0, 0);
							info = play.getStatistics();
							play.stop();
							System.out.println("**** Game Over! ****\n" + "End game: " + info);
							dbc.setScore(get_score());
							int rank = dbc.rank();
							System.out.println("Score: " + dbc.getScore() + ", Rank: " + rank);
							clear();
							repaint();
						} finally {
							lock.unlock();
						}
					}
				}
			}
		}.start();
	}

	/**
	 * Paints our GUI every time repaint() is called, using the game.
	 */
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

	/**
	 * when run manual is activated the first click initiates the players location.
	 */
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

	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

/**
 * When the senerio is being run manually, every time the mouse is pressed the player moves towards the mouse.
 */
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			mouseDown = true;
			manual_Thread(e.getX(),e.getY());
		}
	}

	/**
	 * When the senerio is being run manually, every time the mouse is released the player stops moving.
	 */
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			mouseDown = false;
		}
	}

	/**
	 * This is a Thread that allows the player to move towards the mouse when pressed.
	 * @param x
	 * @param y
	 */
	private void manual_Thread(int x, int y) {
		if (checkAndMark()) {
			new Thread() {
				public void run() {
					do {
						if(game_status.equals("location_initiated")) {
							if(game.fruits_left() && time_left()) {
								move_game_pieces(x, y);
								try {
									Thread.sleep(30);
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
								dbc.setScore(get_score());
								int rank = dbc.rank();
								System.out.println("Score: " + dbc.getScore() + ", Rank: " + rank);
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



	//********************private data and methods********************

	private static final long serialVersionUID = -4858247425376916779L;
	private String game_status;
	private Play play;
	private Map map;
	private Game game;
	private ArrayList<String> board_data;
	private String info;
	private Point pixel_location;
	private final Lock lock = new ReentrantLock();
	private DB_connect dbc = null;

	volatile private boolean mouseDown = false;
	volatile private boolean isRunning = false;

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
		dbc = new DB_connect();
		dbc.setId1(205463920);
		dbc.setId2(311300784);
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


	private LatLonAlt find_best_init_location() {
		LatLonAlt best_location = null;

		if(!game.contains_packmans()) {
			boolean found_fruit = false;
			for(int i = game.getElement_List().size()-1; i > 0 && !found_fruit; i++) {
				if(game.getElement_List().get(i) instanceof Fruit) {
					best_location = game.getElement_List().get(i).getRatio().to_latLon(map);
					found_fruit = true;
				}
			}
		}
		else {
			LatLonAlt fruit_location = null;
			LatLonAlt packman_location = null;

			double best_dist = Double.MIN_VALUE;

			for (Element element1 : game.getElement_List()) {
				if(element1 instanceof Fruit) {
					for (Element element2 : game.getElement_List()) {
						if(element2 instanceof Packman) {
							fruit_location = element1.getRatio().to_latLon(game.getMap());
							packman_location = element2.getRatio().to_latLon(game.getMap());
							if(fruit_location.GPS_distance(packman_location)>best_dist) {
								best_location = fruit_location;
								best_dist = fruit_location.GPS_distance(packman_location);
							}
						}
					}
				}
			}
		}
		return best_location;
	}


	private double get_score() {
		String[] data = info.split(",");
		return Double.parseDouble(data[2].substring(6));
	}


	private boolean fruit_exists(LatLonAlt next_fruit) {
		for (Element element : game.getElement_List()) {
			if(element instanceof Fruit && element.getRatio().to_latLon(game.getMap()).equals(next_fruit))
				return true;
		}
		return false;
	}
	
	
	private boolean time_left() {
		String[] data = info.split(",");
		String time_string = data[3].substring(data[3].indexOf(':')+1);
		double time = Double.parseDouble(time_string);
		return time>100;
	}


	private void move_game_pieces(int x, int y) {
		pixel_location = game.get_me_location().to_pixels(getWidth(), getHeight());
		double angle = Cords.angXY(x-pixel_location.x, pixel_location.y-y);
		play.rotate(angle);
		info = play.getStatistics();
		System.out.println(info);
		update_board_data();
		repaint();		
	}
	
	
	private synchronized boolean checkAndMark() {
		if (isRunning) return false;
		isRunning = true;
		return true;
	}
}
