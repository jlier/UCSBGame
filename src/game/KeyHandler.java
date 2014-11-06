package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public KeyHandler(){
	}

	public void keyPressed(KeyEvent e) {
		if(e.getExtendedKeyCode() == 37) 		//left
			Screen.direction[0] = true;
		else if(e.getExtendedKeyCode() == 38) 	//up
			Screen.direction[1] = true;
		else if(e.getExtendedKeyCode() == 39) 	//right
			Screen.direction[2] = true;
		else if(e.getExtendedKeyCode() == 40)   //down
			Screen.direction[3] = true;
		else
			System.exit(0);
	}

	public void keyReleased(KeyEvent e) {
		Screen.direction[e.getExtendedKeyCode() - 37] = false;
	}

	public void keyTyped(KeyEvent e) {
	}
}
