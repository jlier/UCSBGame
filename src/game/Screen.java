package game;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import objects.Background;
import objects.Drawable;
import objects.Mob;

public class Screen extends JPanel implements Runnable{
	
	public final static int SCREEN_WIDTH = 800;
	public final static int SCREEN_HEIGHT = 600; 
	
	private Thread thread;
	
	private ArrayList<Drawable> mobs;
	private final String[] mobtypes = {"creeper","tank"};
	
	//----Run fields----//
	private int tickCount;
	private final int frameCount;
	//------------------//
	
	//-----Objects------//
	private Background background;
	//------------------//
	
	public Screen(){
		thread = new Thread(this);
		mobs = new ArrayList<Drawable>();

		background = new Background(SCREEN_WIDTH, SCREEN_HEIGHT, "Background", "res/background.png");
		
		addMob("creeper");
		
		tickCount = 0;
		frameCount = 1000;
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