package game;

import objects.Drawable;

public class Collision {
	
	private static int groundOffset = 240;
	
	public static void hitBoundary(Drawable obj){
		if(obj.getXPos() + obj.width > Screen.SCREEN_WIDTH)
			obj.setXPos(Screen.SCREEN_WIDTH - obj.width);
		if(obj.getXPos() < 0)
			obj.setXPos(0);
		if(obj.getYPos() + obj.height + groundOffset > Screen.SCREEN_HEIGHT)
			obj.setYPos(Screen.SCREEN_HEIGHT - obj.height - groundOffset);
		if(obj.getYPos() < 0)
			obj.setYPos(0);
	}
}