package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import objects.Background;
import objects.Drawable;
import objects.Mob;

public class Screen extends JPanel implements Runnable{
	
	public final static int SCREEN_WIDTH = 1800;
	public final static int SCREEN_HEIGHT = 800; 
	
	private Dimension dim;
	
	public final static float MOB_SPEED = 0.5f;
	
	private Thread thread;
	
	private KeyHandler keyHandler;
	public static boolean[] direction = new boolean[4]; //37,38,39,40
	
	private ArrayList<Drawable> mobs;
	private final String[] mobtypes = {"creeper","tank"};
	
	private int tickCount;
	private final int frameCount;
	
	private Background background;
	
	public Screen(JFrame f){
		dim = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
		setPreferredSize(dim);
		setSize(dim);
		
		thread = new Thread(this);
		mobs = new ArrayList<Drawable>();
		keyHandler = new KeyHandler();
		
		f.addKeyListener(keyHandler);

		background = new Background(SCREEN_WIDTH, SCREEN_HEIGHT, "Background", "res/background.png");
		
		addMob("creeper");
		
		tickCount = 0;
		frameCount = 100000;
		thread.start();
	}
	
	public ArrayList<Drawable> getMobList(){
		return this.mobs;
	}
	
	public void addMob(String type){
		if(type.equals(mobtypes[0]))
			mobs.add(new Mob(100, 100, type, "res/creeper.png"));
		else
			mobs.add(new Mob(50, 50, type, "res/tank.png"));
	}
	
	public void removeMob(Drawable mob){
		mobs.remove(mob);
	}
	
	public void update(){
		background.update();
		for (Drawable mob : mobs) {
			mob.update();
		}
	}
	
	public void paintComponent(Graphics g){
		background.draw(g);
		for(Drawable mob: mobs) {
			mob.draw(g);
		}
	}
	
	public void run(){
		while(true){
			if(tickCount == frameCount){
				//New Frame
				update();
				repaint();
				tickCount = 0;
			}
			tickCount++;
		}
	}
}