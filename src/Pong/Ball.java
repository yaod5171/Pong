package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable {

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

    public boolean collideLeft(Object obj) {
        Block block = (Block) obj;
        if (getY() + getHeight() >= block.getY()
                && getY() <= block.getY() + block.getHeight()) {
            if ((getX() + getXSpeed()) <= (block.getX() + block.getWidth())) {
                return true;
            }
        }
        return false;
    }

    public boolean collideRight(Object obj) {
        Block block = (Block) obj;
        if (getY() + getHeight() >= block.getY()
                && getY() <= block.getY() + block.getHeight()) {
            if ((getX() + getWidth() + getXSpeed()) >= (block.getX())) {
                return true;
            }
        }
        return false;
    }

    public boolean collideBottom(Object obj) {
        Block block = (Block) obj;
        if (getX() + getWidth() >= block.getX()
                && getX() <= block.getX() + block.getWidth()) {
            if ((getY() + getHeight() + getYSpeed()) >= (block.getY())) {
                return true;
            }
        }
        return false;
    }

    public boolean collideTop(Object obj) {
        Block block = (Block) obj;
        if (getX() + getWidth() >= block.getX()
                && getX() <= block.getX() + block.getWidth()) {
            if ((getY() + getYSpeed()) >= (block.getY() + block.getHeight())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean collideVertical(Object obj) {
        return (collideBottom(obj) || collideTop(obj));
    }
    
    public boolean collideHorizontal(Object obj) {
        return (collideLeft(obj) || collideRight(obj));
    }
    
    public boolean collide(Object obj) {
        return (collideVertical(obj) || collideHorizontal(obj));
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
