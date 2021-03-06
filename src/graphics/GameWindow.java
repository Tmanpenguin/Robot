package graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;

import gameListeners.GameKeyListener;
import gameObjects.Chunk;
import gameObjects.Entity;
import gameObjects.Item;
import gameObjects.ItemChunk;
import gameObjects.ObjectManager;
import utility.Util; 

/*
 * The point of this class is to display graphics and be the base for handling the display of things to the window
 * 
 * IT DOES NOT CALCULATE THE GRAPHICS, BUT DISPLAYS THEM IN APPROPRIATE LOCATIONS
 */

public class GameWindow extends JFrame {
	
	private static Image myScreen;
	private static Camera c;

	private static final long serialVersionUID = 1L;

	public GameWindow(){
		setup();
		c = new Camera();
		c.setX(1024);
		c.setY(768);
	}
	
	private void setup(){
		
		this.setSize(Util.getScreenWidth(),Util.getScreenHeight());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.addKeyListener(new GameKeyListener());
	}
	
	@Override
	public void paint(Graphics g)
	{    
		myScreen =createImage(getSize().width,getSize().height);
		Graphics o = myScreen.getGraphics();
		doubleBuffer(o);
		g.drawImage(myScreen,0,0,null);
	}
	
	public void doubleBuffer(Graphics g){
		g.drawImage(c.getView(), 0, 0, null);
	}
	
	public static Camera getCamera(){
		return c;
	}
}
