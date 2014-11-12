package objects;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Background extends Drawable{

	private Image bg;
	
	public Background(int width, int height) {
		super(width, height);
		bg = new ImageIcon("res/background.png").getImage();
	}

	@Override
	public void update() {
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(bg, 0, 0, width, height, null);
	}
}