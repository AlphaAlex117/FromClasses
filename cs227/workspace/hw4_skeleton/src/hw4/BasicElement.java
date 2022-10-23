package hw4;

import api.GameElement;
import java.awt.Rectangle;

/**
 * Minimal concrete extension of GameElement. The <code>update</code>
 * method in this implementation just increments the frame count.
 * _____________________________________________________________________
 * DESIGN CHOICES:
 * 
 * 			GameElement
 * 				  ^
 *  			  |
 * Charm ->	BasicElement	<- Flash
 * 				  ^
 * 				  |
 * 			MovingElement
 * 		   ^	  ^		 ^
 * 		  /		  |		  \
 * Platform		Lurker	  Missile
 * 	  ^
 * 	  |
 * Elevator
 * 
 * 	I did the following choices because I paired the classes that had
 * the most in common. For example, a lot of them had the delta and
 * setVelocity methods, which I thought it would be annoying to write
 * again. The child-parent related methods were some that I didn't want
 * to have to extend because of how they relate to other objects and
 * I needed to make sure they worked correctly; on the other hand,
 * methods like setVelocity work with primitive types, which are easy
 * to work with I have better predictions of what it is supposed to do.
 * 
 * 	Also, I understand that platform is not an elevator nor the other
 * way around. I extended it to reduce the amount of code because the
 * elevator class is almost the same as the platform except on a few
 * methods and that it moves on the Y axis. So it was basically 
 * overriding the methods that were different and adapting it to the
 * elevator.
 * ____________________________________________________________________
 * 
 * @author Alexander Lafontaine
 */
public class BasicElement extends GameElement
{
	/**
	 * Stores x value of the basic element.
	 */
	private double xValue = 0.0;
	
	/**
	 * Stores y value of the basic element.
	 */
	private double yValue = 0.0;
	
	/**
	 * Stores width value of the basic element.
	 */
	private int elementWidth = 0;
	
	/**
	 * Stores height value of the basic element.
	 */
	private int elementHeight = 0;
	
	/**
	 * Stores if the object is marked for deletion.
	 */
	private boolean forDeletion = false;
	
	/**
	 * Stores the number of times update() has been called.
	 */
	private int frameCount = 0;
	
	/**
	 * Constructs a new BasicElement.
	 * @param x
	 *   x-coordinate of upper left corner
	 * @param y
	 *   y-coordinate of upper left corner
	 * @param width
	 *   element's width
	 * @param height
	 *   element's height
	 */
	public BasicElement(double x, double y, int width, int height)
	{
		xValue = x;
		yValue = y;
		elementWidth = width;
		elementHeight = height;
	}
	
	/**
	 * Sets the new x and y coordinates.
	 */
	@Override
	public void setPosition(double newX, double newY)
	{
		xValue = newX;
		yValue = newY;
	}
	
	/**
	 * Returns the exact x coordinate.
	 */
	@Override
	public double getXReal()
	{
		return xValue;
	}
	
	/**
	 * Returns the exact y coordinate.
	 */
	@Override
	public double getYReal()
	{
		return yValue;
	}
	
	/**
	 * Updates the frame count.
	 */
	@Override
	public void update()
	{
		addFrameCount();
	}
	
	/**
	 * Returns the number of times the update() method has been called.
	 */
	@Override
	public int getFrameCount()
	{
		return frameCount;
	}
	
	/**
	 * Returns if object is marked for deletion.
	 */
	@Override
	public boolean isMarked()
	{
		return forDeletion;
	}
	
	/**
	 * Marks the object for deletion.
	 */
	@Override
	public void markForDeletion()
	{
		forDeletion = true;
	}
	
	/**
	 * Checks if the boundary rectangles of the object intersect with the other object.
	 */
	@Override
	public boolean collides(GameElement other)
	{
		return getRect().intersects(other.getRect());
	}
	
	/**
	 * Returns the bounding rectangle of the object.
	 */
	@Override
	public Rectangle getRect()
	{
		return new Rectangle(getXInt(), getYInt(), getWidth(), getHeight());
	}
	
	/**
	 * Returns the stored height of the basic element.
	 */
	@Override
	public int getHeight()
	{
		return elementHeight;
	}
	
	/**
	 * Returns the stored width of the basic element.
	 */
	@Override
	public int getWidth()
	{
		return elementWidth;
	}
	
	/**
	 * Returns the integer version of the x coordinate.
	 */
	@Override
	public int getXInt()
	{
		return (int)Math.round(xValue);
	}
	
	/**
	 * Returns the integer version of the y coordinate.
	 */
	@Override
	public int getYInt()
	{
		return (int)Math.round(yValue);
	}
	
	/**
	 * Helper method for counting a frame when updating. Used so that
	 * other classes that override update() can still add to the frame count
	 * without making an additional instance variable or making a protected
	 * instance variable.
	 */
	protected void addFrameCount()
	{
		frameCount += 1;
	}
}
