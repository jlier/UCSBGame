package objects;

import game.Physics;
import game.Screen;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Player extends Drawable {

	private Image[] animation = new Image[8];
	private Image drawimg;

	private int animCounter, right, left;

	private boolean animationFrame;

	public Player() {
		super(Screen.MOB_SIZE, Screen.MOB_SIZE);
		animation[0] = new ImageIcon("res/player-north.png").getImage();
		animation[1] = new ImageIcon("res/player-south.png").getImage();
		animation[2] = new ImageIcon("res/player-right.png").getImage();
		animation[3] = new ImageIcon("res/player-walking-right.png").getImage();
		animation[4] = new ImageIcon("res/player-walking-right-2.png").getImage();
		animation[5] = new ImageIcon("res/player-left.png").getImage();
		animation[6] = new ImageIcon("res/player-walking-left.png").getImage();
		animation[7] = new ImageIcon("res/player-walking-left-2.png").getImage();
		drawimg = animation[1];
		animationFrame = false;
		animCounter = 0;
		right = 0;
		left = 0;
	}

	public void setImage(Image img) {
		this.drawimg = img;
	}

	@Override
	public void update() {
		if (Screen.direction[0]) {
			xpos -= Screen.MOB_SPEED; // left
			if (animationFrame) {
				animCounter++;
				left++;
				if (animCounter == 2)
					left = 5;
				if (animCounter == 3)
					left = 7;
				if (animCounter == 4) {
					animCounter = 0;
					left = 5;
				}
				animationFrame = false;
			}
			drawimg = animation[left];
		}
		if (Screen.direction[1]) { //up
			ypos -= Screen.MOB_SPEED;
			drawimg = animation[0];

		}
		if (Screen.direction[2]) {
			xpos += Screen.MOB_SPEED;
			if (animationFrame) {
				animCounter++;
				right++;
				if (animCounter == 2)
					right = 0;
				if (animCounter == 3)
					right = 2;
				if (animCounter == 4) {
					animCounter = 0;
					right = 0;
				}
				animationFrame = false;
			}
			drawimg = animation[2 + right];
		}

		if (Screen.direction[3]) { //down
			ypos += Screen.MOB_SPEED;
			drawimg = animation[1];
		}

		Physics.hitBoundary(this);
	}

	public void animate() {
		animationFrame = true;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(this.drawimg, (int) xpos, (int) ypos, Screen.MOB_SIZE,
				Screen.MOB_SIZE, null);
	}
}
