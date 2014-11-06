package objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Drawable extends Rectangle{
	
	private String type;
	
	protected float xpos, ypos;
	
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
		g.drawImage(img, (int)xpos, (int)ypos, width, height, null);
	}
	
	public void setXPos(float xpos){
		this.xpos = xpos;
	}
	
	public void setYPos(float ypos){
		this.ypos = ypos;
	}
	
	public float getXPos(){
		return this.xpos;
	}
	
	public float getYPos(){
		return this.ypos;
	}
}