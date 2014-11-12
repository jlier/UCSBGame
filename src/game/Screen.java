package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import objects.Background;
import objects.Bubble;
import objects.Drawable;
import objects.Mob;
import objects.Player;

public class Screen extends JPanel implements Runnable{
	
	public final static int SCREEN_WIDTH = 1800;
	public final static int SCREEN_HEIGHT = 800; 
	public final static int MOB_SIZE = 120;
	
	public final static HashMap<String, String> IMG_PATHS = new HashMap<String, String>();
	
	private Dimension dim;
	
	public final static float MOB_SPEED = 0.3f;
	
	private Thread thread;
	
	private KeyHandler keyHandler;
	public static boolean[] direction = new boolean[4]; //37,38,39,40
	
	private ArrayList<Drawable> mobs;
	
	private int tickCount;
	private final int frameCount;
	private int frames;
	
	private Background background;
	private Bubble bubble;
	
	private static Player player;
	
	public Screen(JFrame f){
		dim = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
		setPreferredSize(dim);
		setSize(dim);
		IMG_PATHS.put("sniper", "res/sniper.png");
		IMG_PATHS.put("tank", "res/tank.png");
		
		thread = new Thread(this);
		mobs = new ArrayList<Drawable>();
		keyHandler = new KeyHandler();
		
		f.addKeyListener(keyHandler);

		background = new Background(SCREEN_WIDTH, SCREEN_HEIGHT);
		player = new Player();
		bubble = new Bubble(MOB_SIZE, MOB_SIZE);
		
		tickCount = 0;
		frameCount = 200000;
		frames = 0;
		thread.start();
	}
	
	public static Player getPlayer(){
		return player;
	}
	
	public ArrayList<Drawable> getMobList(){
		return this.mobs;
	}
	
	public void addMob(String type){
		mobs.add(new Mob(type));
	}
	
	public void removeMob(Drawable mob){
		mobs.remove(mob);
	}
	
	public void update(){
		background.update();
		for (Drawable mob : mobs) {
			mob.update();
		}
		player.update();
		bubble.update();
	}
	
	public void paintComponent(Graphics g){
		background.draw(g);
		for(Drawable mob: mobs) {
			mob.draw(g);
		}
		player.draw(g);
		bubble.draw(g);
	}
	
	public void run(){
		while(true){
			if(tickCount == frameCount){
				if(frames == 600){
					player.animate();
					frames = 0;
				}
				update();
				repaint();
				tickCount = 0;
				frames++;
			}
			tickCount++;
		}
	}
}