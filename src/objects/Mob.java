package objects;

import game.Collision;
import game.Screen;

public class Mob extends Drawable{

	public Mob(int width, int height, String type, String imgpath) {
		super(width, height, type, imgpath);
		xpos = 400;
		ypos = 200;
	}

	@Override
	public void update() {
		if(Screen.direction[0])
			xpos -= Screen.MOB_SPEED;
		if(Screen.direction[1])
			ypos -= Screen.MOB_SPEED;
		if(Screen.direction[2])
			xpos += Screen.MOB_SPEED;
		if(Screen.direction[3])
			ypos += Screen.MOB_SPEED;

		Collision.hitBoundary(this);
	}
}