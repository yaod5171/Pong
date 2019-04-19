package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import javax.swing.JFrame;
import java.awt.Component;

public class BallsRunner extends JFrame
{
	private static final int WIDTH = 1600;
	private static final int HEIGHT = 900;

	public BallsRunner()
	{
		super("PONG");
		setSize(WIDTH,HEIGHT);
		Balls balls = new Balls(1500);

		((Component)balls).setFocusable(true);
		getContentPane().add(balls);

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		BallsRunner run = new BallsRunner();
	}
}