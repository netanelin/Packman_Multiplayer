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

import javax.swing.JFrame;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import Coords.Cords;
import Coords.LatLonAlt;
import Game_Elements_For_Gui.Gui_Box;
import Game_Elements_For_Gui.Gui_Element;
import Game_Elements_For_Gui.Gui_Game;
import Game_Elements_For_Gui.Gui_Map;
import Game_Elements_For_Gui.Ratio;
import Robot.Play;

public class Main_Window extends JFrame implements MouseListener, MenuListener {

	BufferedImage myImage=null;
	private String game_status;
	private Play play;
	private Gui_Map map;
	private Gui_Game game;
	private ArrayList<String> board_data;
	private String info;
	private Point pixel_location;


	public Main_Window() 
	{
		initGUI();
		this.addMouseListener(this); 
	}




	private void initGUI() 
	{
		initMENU();
		map= new Gui_Map(new LatLonAlt(32.101898,35.202369,0.0), new LatLonAlt(32.105728,35.212416,0.0));
		game = new Gui_Game(map);
		myImage = game.getMap().getMyImage();
		game_status = "nothing";
		board_data = new ArrayList<String>();
		pixel_location = new Point();
	}



	private void initMENU() {

		MenuBar menuBar = new MenuBar();

		Menu Choose_senerio = new Menu("Choose senerio");
		Menu run = new Menu("Run");
		Menu clear = new Menu("clear");

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

		menuBar.add(Choose_senerio);
		menuBar.add(run);
		menuBar.add(clear);
		clear(clear);

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

		this.setMenuBar(menuBar);

	}



	private void clear(Menu clear) {
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				board_data.clear();
				game.clearAll();
				play = null;
				repaint();
				game_status = "nothing";
			}
		});		
	}




	private void update_board_data() {
		game.clearAll();
		board_data.clear();
		board_data = play.getBoard();
		for(int i=0;i<board_data.size();i++) {
			if(board_data.get(i).charAt(0)=='B') {
				game.addBox(new Gui_Box(board_data.get(i), map));
			}
			else {
				game.addElement(new Gui_Element(board_data.get(i), map));
			}
		}
	}



	private void senerio_1(MenuItem senerio_1) {
		senerio_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game_status ="senerio_active"; 
				game.clearAll();
				String file_name = "data//Ex4_OOP_example1.csv";
				play = new Play(file_name);
				play.setIDs(205463920,311300784);
				update_board_data();
				repaint();
			}
		});		
	}


	private void senerio_2(MenuItem senerio_2) {
		senerio_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game_status ="senerio_active";
				game.clearAll();
				String file_name = "data//Ex4_OOP_example2.csv";
				play = new Play(file_name);
				play.setIDs(205463920,311300784);
				update_board_data();
				repaint();
			}			
		});				
	}


	private void senerio_3(MenuItem senerio_3) {
		senerio_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game_status ="senerio_active"; 
				game.clearAll();
				String file_name = "data//Ex4_OOP_example3.csv";
				play = new Play(file_name);
				play.setIDs(205463920,311300784);
				update_board_data();
				repaint();
			}
		});				
	}


	private void senerio_4(MenuItem senerio_4) {
		senerio_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game_status ="senerio_active"; 
				game.clearAll();
				String file_name = "data//Ex4_OOP_example4.csv";
				play = new Play(file_name);
				play.setIDs(205463920,311300784);
				update_board_data();
				repaint();
			}
		});				
	}


	private void senerio_5(MenuItem senerio_5) {
		senerio_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game_status ="senerio_active";
				game.clearAll();
				String file_name = "data//Ex4_OOP_example5.csv";
				play = new Play(file_name);
				play.setIDs(205463920,311300784);
				update_board_data();
				repaint();
			}
		});				
	}



	private void senerio_6(MenuItem senerio_6) {
		senerio_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game_status ="senerio_active"; 
				game.clearAll();
				String file_name = "data//Ex4_OOP_example6.csv";
				play = new Play(file_name);
				play.setIDs(205463920,311300784);
				update_board_data();
				repaint();
			}
		});				
	}


	private void senerio_7(MenuItem senerio_7) {
		senerio_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game_status ="senerio_active"; 
				game.clearAll();
				String file_name = "data//Ex4_OOP_example7.csv";
				play = new Play(file_name);
				play.setIDs(205463920,311300784);
				update_board_data();
				repaint();
			}
		});				
	}


	private void senerio_8(MenuItem senerio_8) {
		senerio_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game_status ="senerio_active"; 
				game.clearAll();
				String file_name = "data//Ex4_OOP_example8.csv";
				play = new Play(file_name);
				play.setIDs(205463920,311300784);
				update_board_data();
				repaint();
			}
		});				
	}



	private void senerio_9(MenuItem senerio_9) {
		senerio_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game_status ="senerio_active"; 
				game.clearAll();
				String file_name = "data//Ex4_OOP_example9.csv";
				play = new Play(file_name);
				play.setIDs(205463920,311300784);
				update_board_data();
				repaint();
			}
		});				
	}






	private void run_manual(MenuItem run_manual) {
		run_manual.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game_status = "run_game_manual";
				//				if(game_status.equals("senerio_active"))
				//					game_status = "";
				//				while(player_start) {
				//
				//				}
				//				play.start();
				//				info = play.getStatistics();
				//				System.out.println(info);
				//				game_on = true;
				//				while(fruits_left() && time_left())
				//				{
				//
				//				}
				//				game_on = false;
				//				play.stop();
				//				System.out.println("**** Done Game (user stop) ****");
				//				repaint();
			}

		});		
	}



	private void run_algorithm(MenuItem run_algorithm) {
		run_algorithm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});		
	}












	public void paint(Graphics g){
		g.drawImage(myImage, 0, 0,getWidth()-8,getHeight()-8, this);




		for(Gui_Box box: game.getBoxes()) {
			Point minPixels = box.getMin_ratio().to_pixels(getWidth(), getHeight());
			Point maxPixels = box.getMax_ratio().to_pixels(getWidth(), getHeight());

			g.setColor(Color.BLACK);
			int rectWidth = maxPixels.x-minPixels.x;
			int rectHeight = minPixels.y-maxPixels.y;
			g.fillRect(minPixels.x, maxPixels.y, rectWidth, rectHeight);
		}

		for(Gui_Element element: game.getElements()) {
			Point Pixels = element.getRatio().to_pixels(getWidth(), getHeight());
			g.drawImage(element.getImage(), Pixels.x-8, Pixels.y-8, getWidth()/50, getHeight()/25, this);
		}
	}






	@Override
	public void menuCanceled(MenuEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuSelected(MenuEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseClicked(MouseEvent e) {

		if(game_status.equals("run_game_manual")) {
			Ratio location = new Ratio(new Point(e.getX(),e.getY()), getWidth(), getHeight());
			//			pixel_location = location.to_pixels(getWidth(), getHeight());
			//			pixel_location.setLocation(e.getX(), e.getY());
			LatLonAlt gps_location = location.to_latLon(map);
			play.setInitLocation(gps_location.lat(),gps_location.lon());
			play.start();
			info = play.getStatistics();
			System.out.println(info);
			update_board_data();
			repaint();
			game_status = "location_initiated";
		}

		else if(game_status.equals("location_initiated")) {
			if(fruits_left()) {
				int x = e.getX(), y = e.getY();
				move_game_pieces(x, y);
				//				pixel_location = get_pixel_location();
				//				double angel = Cords.angXY(x-pixel_location.x, pixel_location.y-y);
				//				System.out.println(angel);
				//				play.rotate(angel);
				//				info = play.getStatistics();
				//				System.out.println(info);
				//				update_board_data();
				//				repaint();
			}
			else {
				game_status = "end_game";
				play.stop();
				update_board_data();
				System.out.println("**** Done Game (user stop) ****");
				repaint();
			}
		}
	}




	private void move_game_pieces(int x, int y) {
		pixel_location = get_pixel_location();
		double angel = Cords.angXY(x-pixel_location.x, pixel_location.y-y);
		System.out.println(angel);
		play.rotate(angel);
		info = play.getStatistics();
		System.out.println(info);
		update_board_data();
		repaint();		
	}




	private Point get_pixel_location() {
		for(Gui_Element element: game.getElements()) {
			if(element.getElement_type()=='M') {
				Ratio ratio = element.getRatio();
				return ratio.to_pixels(getWidth(), getHeight());
			}
		}
		return null;
	}




	private boolean fruits_left() {
		update_board_data();
		boolean fruits_left = false;
		for(Gui_Element element: game.getElements()) {
			if(element.getElement_type()=='F')
				fruits_left = true;
		}
		return fruits_left;
	}



	//	public boolean time_left() {
	//		String[] data = info.split(",");
	//		double time = Double.parseDouble(data[3].substring(data[3].indexOf(':')+1));
	//		return time>0;
	//	}







	@Override
	public void mouseEntered(MouseEvent arg0) {
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	//	private boolean pressed = false;
	//	@Override
	//	public void mousePressed(MouseEvent e) {
	//		// TODO Auto-generated method stub
	//		pressed = true;
	//		if(game_status.equals("location_initiated")) {
	//			while(e.getButton()) {
	//				move_game_pieces(e.getX(), e.getY());
	//				try {
	//					Thread.sleep(250);
	//				} catch (InterruptedException e1) {
	//					// TODO Auto-generated catch block
	//					e1.printStackTrace();
	//				}
	//			}
	//		}
	//	}
	//
	//	@Override
	//	public void mouseReleased(MouseEvent arg0) {
	//		// TODO Auto-generated method stub
	//		pressed = false;
	//	}





	volatile private boolean mouseDown = false;

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			mouseDown = true;
			initThread(e.getX(),e.getY());
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
	private void initThread(int x, int y) {
		if (checkAndMark()) {
			new Thread() {
				public void run() {
					do {
						if(game_status.equals("location_initiated")) {
							move_game_pieces(x, y);
							try {
								Thread.sleep(50);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					} while (mouseDown);
					isRunning = false;
				}
			}.start();
		}
	}



}
