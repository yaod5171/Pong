package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable {

    private int xPos;
    private int yPos;
    private int width;
    private int height;

    private Color color;

    public Block() {
        xPos = 0;
        yPos = 0;
        width = 0;
        height = 0;
    }
    
    public Block(int x, int y) {
        xPos = x;
        yPos = y;
        width = 10;
        height = 10;
    }

    public Block(int x, int y, int Width, int Height) {
        xPos = x;
        yPos = y;
        width = Width;
        height = Height;
    }

    public Block(int x, int y, int Width, int Height, Color col) {
        xPos = x;
        yPos = y;
        width = Width;
        height = Height;
        color = col;
    }

    //add the other set methods
    public void setColor(Color col) {
        color = col;
    }

    public void setPos(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public void setX(int x) {
        xPos = x;
    }

    public void setY(int y) {
        yPos = y;
    }

    public void setWidth(int Width) {
        width = Width;
    }

    public void setHeight(int Height) {
        height = Height;
    }

    public void draw(Graphics window) {
        //uncomment after you write the set and get methods
        window.setColor(color);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void draw(Graphics window, Color col) {

    }

    public boolean equals(Object obj) {
        Block comp = (Block)obj;
        //check if color matches
        boolean colorsMatch;
        if (getColor() == null && comp.getColor() == null) {
            colorsMatch = true;
        } else if (getColor() == null || comp.getColor() == null) {
            colorsMatch = false;
        } else {
            colorsMatch = getColor().equals(comp.getColor());
        }
        //check everything else
        return (getX() == comp.getX() && getY() == comp.getY() && 
            getWidth() == comp.getWidth() && getHeight() == comp.getHeight()
            && colorsMatch);
    }

    //add the other get methods
    public Color getColor() {
        return color;
    }
    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    //add a toString() method  - x , y , width, height, color
    public String toString() {
        return xPos + " " + yPos + " " + width + " " + height + " " + color;
    }
}
