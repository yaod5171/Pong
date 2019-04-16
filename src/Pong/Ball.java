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

        setX(getX() + xSpeed);
		//setY
        setY(getY() + ySpeed);

        //draw the ball at its new location
    }

    public boolean equals(Object obj) {
        Ball comp = (Ball)obj;
        return (xSpeed == comp.getXSpeed() && ySpeed == comp.getYSpeed() &&
                super.equals(comp));
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
        return getX() + " " + getY() + " " + 
                getWidth() + " " + getHeight() + " " + 
                getColor() + " " + xSpeed + " " + ySpeed;
    }
}
