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

import Coords.LatLonAlt;
import Game_Elements_For_Gui.Gui_Box;
import Game_Elements_For_Gui.Gui_Element;
import Game_Elements_For_Gui.Gui_Game;
import Game_Elements_For_Gui.Gui_Map;
import Robot.Play;

public class Main_Window extends JFrame implements MouseListener, MenuListener {

	BufferedImage myImage=null;
	private boolean senerio_active;
	private Play play;
	private Gui_Map map;
	private Gui_Game game;

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
		senerio_active = false;
	}



	private void initMENU() {

		MenuBar menuBar = new MenuBar();

		Menu Choose_senerio = new Menu("Choose senerio");
		Menu run = new Menu("Run");

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







	private void senerio_1(MenuItem senerio_1) {
		senerio_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_active = true;
				game.clearAll();
				String file_name = "data//Ex4_OOP_example1.csv";
				play = new Play(file_name);
				ArrayList<String> board_data = play.getBoard();
				for(int i=0;i<board_data.size();i++) {
					if(board_data.get(i).charAt(0)=='B') {
						game.addBox(new Gui_Box(board_data.get(i), map));
					}
					else {
						game.addElement(new Gui_Element(board_data.get(i), map));
					}
				}
				repaint();
			}
		});		
	}


	private void senerio_2(MenuItem senerio_2) {
		senerio_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_active = true;
				game.clearAll();
				String file_name = "data//Ex4_OOP_example2.csv";
				play = new Play(file_name);
				ArrayList<String> board_data = play.getBoard();
				for(int i=0;i<board_data.size();i++) {
					if(board_data.get(i).charAt(0)=='B') {
						game.addBox(new Gui_Box(board_data.get(i), map));
					}
					else {
						game.addElement(new Gui_Element(board_data.get(i), map));
					}
				}
				repaint();
			}			
		});				
	}


	private void senerio_3(MenuItem senerio_3) {
		senerio_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_active = true;
				game.clearAll();
				String file_name = "data//Ex4_OOP_example3.csv";
				play = new Play(file_name);
				ArrayList<String> board_data = play.getBoard();
				for(int i=0;i<board_data.size();i++) {
					if(board_data.get(i).charAt(0)=='B') {
						game.addBox(new Gui_Box(board_data.get(i), map));
					}
					else {
						game.addElement(new Gui_Element(board_data.get(i), map));
					}
				}
				repaint();
			}
		});				
	}


	private void senerio_4(MenuItem senerio_4) {
		senerio_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_active = true;
				game.clearAll();
				String file_name = "data//Ex4_OOP_example4.csv";
				play = new Play(file_name);
				ArrayList<String> board_data = play.getBoard();
				for(int i=0;i<board_data.size();i++) {
					if(board_data.get(i).charAt(0)=='B') {
						game.addBox(new Gui_Box(board_data.get(i), map));
					}
					else {
						game.addElement(new Gui_Element(board_data.get(i), map));
					}
				}
				repaint();
			}
		});				
	}


	private void senerio_5(MenuItem senerio_5) {
		senerio_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_active = true;
				game.clearAll();
				String file_name = "data//Ex4_OOP_example5.csv";
				play = new Play(file_name);
				ArrayList<String> board_data = play.getBoard();
				for(int i=0;i<board_data.size();i++) {
					if(board_data.get(i).charAt(0)=='B') {
						game.addBox(new Gui_Box(board_data.get(i), map));
					}
					else {
						game.addElement(new Gui_Element(board_data.get(i), map));
					}
				}
				repaint();
			}
		});				
	}



	private void senerio_6(MenuItem senerio_6) {
		senerio_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_active = true;
				game.clearAll();
				String file_name = "data//Ex4_OOP_example6.csv";
				play = new Play(file_name);
				ArrayList<String> board_data = play.getBoard();
				for(int i=0;i<board_data.size();i++) {
					if(board_data.get(i).charAt(0)=='B') {
						game.addBox(new Gui_Box(board_data.get(i), map));
					}
					else {
						game.addElement(new Gui_Element(board_data.get(i), map));
					}
				}
				repaint();
			}
		});				
	}


	private void senerio_7(MenuItem senerio_7) {
		senerio_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_active = true;
				game.clearAll();
				String file_name = "data//Ex4_OOP_example7.csv";
				play = new Play(file_name);
				ArrayList<String> board_data = play.getBoard();
				for(int i=0;i<board_data.size();i++) {
					if(board_data.get(i).charAt(0)=='B') {
						game.addBox(new Gui_Box(board_data.get(i), map));
					}
					else {
						game.addElement(new Gui_Element(board_data.get(i), map));
					}
				}
				repaint();
			}
		});				
	}


	private void senerio_8(MenuItem senerio_8) {
		senerio_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_active = true;
				game.clearAll();
				String file_name = "data//Ex4_OOP_example8.csv";
				play = new Play(file_name);
				ArrayList<String> board_data = play.getBoard();
				for(int i=0;i<board_data.size();i++) {
					if(board_data.get(i).charAt(0)=='B') {
						game.addBox(new Gui_Box(board_data.get(i), map));
					}
					else {
						game.addElement(new Gui_Element(board_data.get(i), map));
					}
				}
				repaint();
			}
		});				
	}



	private void senerio_9(MenuItem senerio_9) {
		senerio_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				senerio_active = true;
				game.clearAll();
				String file_name = "data//Ex4_OOP_example9.csv";
				play = new Play(file_name);
				ArrayList<String> board_data = play.getBoard();
				for(int i=0;i<board_data.size();i++) {
					if(board_data.get(i).charAt(0)=='B') {
						game.addBox(new Gui_Box(board_data.get(i), map));
					}
					else {
						game.addElement(new Gui_Element(board_data.get(i), map));
					}
				}
				repaint();
			}
		});				
	}






	private void run_manual(MenuItem run_manual) {
		run_manual.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

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
			g.drawImage(element.getImage(), Pixels.x, Pixels.y, getWidth()/50, getHeight()/25, this);
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
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
