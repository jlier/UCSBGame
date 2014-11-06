package game;

import javax.swing.JFrame;

public class UCSBGame extends JFrame{
	
	private Screen screen; 
	
	public UCSBGame(){
		screen = new Screen(this);
		initFrame();
	}
	
	public void initFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(screen);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new UCSBGame();
	}

}
