package objects;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Drawable extends Rectangle{
	
	private String type;
	
	protected float xpos, ypos;
	
	public Drawable(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public String getType() {
		return type;
	}

	public abstract void update();
	
	public abstract void draw(Graphics g);
	
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