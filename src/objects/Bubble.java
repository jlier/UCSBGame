package objects;

import game.Screen;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Bubble extends Drawable{
	
	private Image img;
	
	public static boolean show = false; 

	public Bubble(int width, int height) {
		super(width, height);
		img = new ImageIcon("res/bubble.png").getImage();
	}

	@Override
	public void update() {
		
	}

	@Override
	public void draw(Graphics g) {
		xpos = Screen.getPlayer().xpos - Screen.MOB_SIZE/1.5f;
		ypos = Screen.getPlayer().ypos - Screen.MOB_SIZE/1.2f;
		if(show)
			g.drawImage(img, (int)xpos, (int)ypos, width, height, null);
	}

}
