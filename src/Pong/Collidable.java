package Pong;

//� A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public interface Collidable
{
	public boolean collideLeft(Object obj);
	public boolean collideRight(Object obj);
	public boolean collideTop(Object obj);
	public boolean collideBottom(Object obj);
}