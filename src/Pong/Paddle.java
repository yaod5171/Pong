package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block {

    //instance variables
    private int speed;

    public Paddle() {
        super(10, 10);
        speed = 5;
    }

    public Paddle(int x, int y) {
        super(x, y);
        speed = 5;
    }

    public Paddle(int x, int y, int vy) {
        super(x, y);
        speed = vy;
    }

    public Paddle(int x, int y, int width, int height) {
        super(x, y, width, height);
        speed = 5;
    }

    public Paddle(int x, int y, int width, int height, int vy) {
        super(x, y, width, height);
        speed = vy;
    }

    public Paddle(int x, int y, int width, int height, Color color, int vy) {
        super(x, y, width, height, color);
        speed = vy;
    }

    public void moveUpAndDraw(Graphics window) {
        window.setColor(Color.WHITE);
        window.fillRect(getX(), getY(), getWidth(), getHeight());

        setY(getY() - getSpeed());

        window.setColor(getColor());
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void moveDownAndDraw(Graphics window) {
        window.setColor(Color.WHITE);
        window.fillRect(getX(), getY(), getWidth(), getHeight());

        setY(getY() + getSpeed());

        window.setColor(getColor());
        window.fillRect(getX(), getY(), getWidth(), getHeight());

    }

   //add get methods
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public String toString() {
        return super.toString() + " " + speed;
    }
}
