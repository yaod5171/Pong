package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.Random;

public class Balls extends Canvas implements Runnable {

    private Ball[] balls;
    private BufferedImage back;

    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;

    public Balls(int count) {
        //set up all variables related to the game
        balls = new Ball[count];
        for (int i = 0; i < count; i++) {
            balls[i] = new Ball((int) (Math.random() * (WIDTH-200) + 100),
                    (int) (Math.random() * (HEIGHT-200) + 100),
                    10, 10, randomColor(),
                    (int)(Math.random()*7-3), (int)(Math.random()*7-3));
        }

        setBackground(Color.WHITE);
        setVisible(true);

        new Thread(this).start();
    }

    public static Color randomColor() {
        int r = (int) (Math.random() * 256);		//use Math.random()
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b);
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        //set up the double buffering to make the game animation nice and smooth
        Graphics2D twoDGraph = (Graphics2D) window;

        //take a snap shop of the current screen and same it as an image
        //that is the exact same width and height as the current screen
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }

        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();

        //update each ball
        for (Ball ball : balls) {
            //see if ball hits left wall or right wall
            if (ball.getX() <= 0 || (ball.getX() + ball.getWidth()) >= WIDTH) {
                ball.setXSpeed(-ball.getXSpeed());
            }

            //see if the ball hits the top or bottom wall 
            if (ball.getY() <= 0 || (ball.getY() + ball.getHeight()) >= getHeight()) {
                ball.setYSpeed(-ball.getYSpeed());
            }

            //if the ball collides with another ball
            for (Ball comp : balls) {
                if (!ball.equals(comp)) {
                if (ball.collideHorizontal(comp)) {
                    int temp = ball.getXSpeed();
                    ball.setXSpeed(comp.getXSpeed());
                    comp.setXSpeed(temp);
                }

                if (ball.collideVertical(comp)) {
                    int temp = ball.getYSpeed();
                    ball.setYSpeed(comp.getYSpeed());
                    comp.setYSpeed(temp);
                }}
            }
            
            ball.moveAndDraw(graphToBack);
        }
        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(8);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
