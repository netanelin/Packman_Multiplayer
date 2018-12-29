package GUI;

import javax.swing.JFrame;

import Coords.Cords;

/**
 * This is a main class for activating our GUI.
 * @author Eitan Lichtman, Netanel Indik
 */
public class GUI_Main 
{
	
	/**
	 * Main method for activating GUI.
	 * @param args
	 */
	public static void main(String[] args)
	{
		Main_Window window = new Main_Window();
		window.setVisible(true);
		window.setSize(window.myImage.getWidth()-8,window.myImage.getHeight()-8);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

