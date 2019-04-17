package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BallTestTwo extends Canvas implements Runnable
{
	private Ball ball;

	public BallTestTwo()
	{
		setBackground(Color.WHITE);
		setVisible(true);

		//instantiate a new Ball
                ball = new Ball(200, 200, 25, 25, Color.RED);

		//test the Ball thoroughly
		

		//test all constructors


		new Thread(this).start();
	}
	/*
	public void update(Graphics window)
	{
		paint(window);
	}
*/
	public void paint(Graphics window)
	{
		ball.moveAndDraw(window);

		if(!(ball.getX()>=0 && (ball.getX()+ball.getWidth())<=getWidth()))
		{
			ball.setXSpeed(-ball.getXSpeed());
		}

		if(!(ball.getY()>=0 && (ball.getY()+ball.getHeight())<=getHeight()))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}
	}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(19);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}