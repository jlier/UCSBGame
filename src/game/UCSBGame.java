package game;

import java.awt.Dimension;
import javax.swing.JFrame;

public class UCSBGame extends JFrame{
	
	private Dimension dim;
	
	private Screen screen; 
	
	public UCSBGame(){
		dim = new Dimension(Screen.SCREEN_WIDTH, Screen.SCREEN_HEIGHT);
		screen = new Screen();
		initFrame();
	}
	
	public void initFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(dim);
		setSize(dim);
		getContentPane().add(screen);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new UCSBGame();
	}

}
