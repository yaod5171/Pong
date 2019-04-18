package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block {

    private int xSpeed;
    private int ySpeed;

    public Ball() {
        super(200, 200);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y) {
        super(x, y);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y, int width, int height) {
        super(x, y, width, height);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y, int width, int height, int vx, int vy) {
        super(x, y, width, height);
        xSpeed = vx;
        ySpeed = vy;
    }

    public Ball(int x, int y, int width, int height, Color color, int vx, int vy) {
        super(x, y, width, height, color);
        xSpeed = vx;
        ySpeed = vy;
    }

    //add the set methods
    public void setXSpeed(int vx) {
        xSpeed = vx;
    }

    public void setYSpeed(int vy) {
        ySpeed = vy;
    }

    public void moveAndDraw(Graphics window) {
        //draw a white ball at old ball location
        window.setColor(Color.WHITE);
        window.fillRect(getX(), getY(), getWidth(), getHeight());

        setX(getX() + xSpeed);
        setY(getY() + ySpeed);

        //draw the ball at its new location
        window.setColor(getColor());
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }
    
    public void moveAndDraw(Graphics window, Color col) {
        //draw a white ball at old ball location
        window.setColor(Color.WHITE);
        window.fillRect(getX(), getY(), getWidth(), getHeight());

        setX(getX() + xSpeed);
        setY(getY() + ySpeed);

        //draw the ball at its new location
        window.setColor(col);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public boolean horizontalCollideWith(Object obj) {
        Block block = (Block)obj;
        if (getY() + getHeight() >= block)
        if ((getX() + getXSpeed()) <= (block.getX() + block.getWidth()))
    }
    
    
    public boolean equals(Object obj) {
        Ball comp = (Ball) obj;
        return (xSpeed == comp.getXSpeed() && ySpeed == comp.getYSpeed()
                && super.equals(comp));
    }

    //add the get methods
    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }

    //add a toString() method
    public String toString() {
        return super.toString() + " " + xSpeed + " " + ySpeed;
    }
}
