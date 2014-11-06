package objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Drawable extends Rectangle{
	
	private String type;
	
	protected int xpos, ypos;
	
	private Image img;
	
	public Drawable(int width, int height, String type, String imgpath){
		this.width = width;
		this.height = height;
		this.type = type;
		
		img = new ImageIcon(imgpath).getImage();
	}
	
	public String getType() {
		return type;
	}

	public abstract void update();
	
	public void draw(Graphics g){
		g.drawImage(img, xpos, ypos, width, height, null);
	}
}