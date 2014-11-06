package objects;

public class Mob extends Drawable{

	public Mob(int width, int height, String type, String imgpath) {
		super(width, height, type, imgpath);
		xpos = 400;
		ypos = 300;
	}

	@Override
	public void update() {
	
	}
}
