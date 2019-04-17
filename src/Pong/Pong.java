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

public class Pong extends Canvas implements KeyListener, Runnable {

    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private boolean[] keys;
    private BufferedImage back;

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public Pong() {
        //set up all variables related to the game
        ball = new Ball(WIDTH / 2, HEIGHT / 2, 25, 25, Color.RED);
        leftPaddle = new Paddle(10, (HEIGHT - 100) / 2, 25, 100, Color.BLUE, 2);
        rightPaddle = new Paddle(WIDTH - 45, (HEIGHT - 100) / 2, 25, 100, Color.BLUE, 2);
        keys = new boolean[4];

        setBackground(Color.WHITE);
        setVisible(true);

        new Thread(this).start();
        addKeyListener(this);		//starts the key thread to log key strokes
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

        leftPaddle.draw(graphToBack, Color.WHITE);
        rightPaddle.draw(graphToBack, Color.WHITE);

        //see if ball hits left wall or right wall
        if (!(ball.getX() >= 0 && (ball.getX() + ball.getWidth()) <= WIDTH)) {
            ball.setXSpeed(-ball.getXSpeed());
            //ball.setXSpeed(0);
            //ball.setYSpeed(0);
        }

        //see if the ball hits the top or bottom wall 
        if (!(ball.getY() >= 0 && (ball.getY() + ball.getHeight()) <= getHeight())) {
            ball.setYSpeed(-ball.getYSpeed());
        }
        
        //see if the ball hits the left paddle

        //see if the ball hits the right paddle
        //see if the paddles need to be moved
        if (keys[0] == true && leftPaddle.getY() > 0) {
            //move left paddle up and draw it on the window
            leftPaddle.moveUpAndDraw(window);
        }
        if (keys[1] == true && (leftPaddle.getY() + leftPaddle.getHeight()) < HEIGHT) {
            //move left paddle down and draw it on the window
            leftPaddle.moveDownAndDraw(window);
        }
        if (keys[2] == true && rightPaddle.getY() > 0) {
            rightPaddle.moveUpAndDraw(window);
        }
        if (keys[3] == true && (rightPaddle.getY() + rightPaddle.getHeight()) < HEIGHT) {
            rightPaddle.moveDownAndDraw(window);
        }

        ball.moveAndDraw(graphToBack);
        leftPaddle.draw(graphToBack);
        rightPaddle.draw(graphToBack);

        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void keyPressed(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = true;
                break;
            case 'Z':
                keys[1] = true;
                break;
            case 'I':
                keys[2] = true;
                break;
            case 'M':
                keys[3] = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = false;
                break;
            case 'Z':
                keys[1] = false;
                break;
            case 'I':
                keys[2] = false;
                break;
            case 'M':
                keys[3] = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
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
