package hw4;

import api.GameElement;

/**
 * Moving element associated with a Platform or Elevator.  Optionally,
 * a Lurker can be given a nonzero horizontal velocity and it will oscillate
 * between the left and right edges of the Platform or Elevator.
 * 
 * @author Alexander Lafontaine
 */
public class Lurker extends MovingElement
{
	/**
	 * Stores the lurker's initial offset.
	 */
	private int lurkerOffset = 0;
	
	/**
	 * Stores the lurker's parent.
	 */
	private Platform lurkerParent;
	
	/**
	 * Stores the lurker's maximum boundary.
	 */
	private double lurkerMax = 0.0;
	
	/**
	 * Stores the lurker's minimum boundary.
	 */
	private double lurkerMin = 0.0;
	
  /**
   * Constructs a new Lurker.  Before being added to a parent element
   * such as a Platform or Elevator, the x and y coordinates are zero.  
   * When a parent element is set, the initial x-coordinate becomes
   * the parent's x-coordinate, plus the given offset, and the y-coordinate
   * becomes the parent's y-coordinate, minus this element's height.
   * @param width
   *   element's width
   * @param height
   *   element's height
   * @param initialOffset
   *   when a parent is set, this amount is added to the parent's x-coordinate
   *   to calculate this element's initial x-coordinate
   */
  public Lurker(int width, int height, int initialOffset)
  {
    super(0, 0, width, height);
    lurkerOffset = initialOffset;
  }
  
  /**
   * Returns the lurker's maximum boundary.
   * @return lurkerMax
   */
  public double getMax()
  {
	  return lurkerMax;
  }
  
  /**
   * Returns the lurker's minimum boundary.
   * @return
   */
  public double getMin()
  {
	  return lurkerMin;
  }
  
  /**
   * Sets the minimum and maximum bounds of the lurker.
   * @param min
   * @param max
   */
  public void setBounds(double min, double max)
  {
	  lurkerMin = min;
	  lurkerMax = max;
  }
  
  /**
   * Sets the lurker's parent.
   * 
   * The reason to cast it as a Platform type is because of the
   * hierarchy and how I left the parent-related methods below 
   * Platform. Also the compiler can now recognize the methods.
   * 
   * @param p
   */
  public void setParent(GameElement p)
  {
	  lurkerParent = (Platform) p;
	  super.setPosition(lurkerParent.getXReal() + lurkerOffset, lurkerParent.getYReal() - super.getHeight());
	  setBounds(lurkerParent.getXReal(), lurkerParent.getXReal() + lurkerParent.getWidth());
  }
  
  /**
   * Adds a frame count. It also updates the position of the lurker relative
   * to the platform or elevator. It also sets the new bounds relative to the 
   * parent's position. Then, it updates the position in case it went beyond
   * its boundaries.
   */
  @Override
  public void update()
  {
	  addFrameCount();
	  if (lurkerParent != null)
	  {
		  super.setPosition(super.getXReal() + super.getDeltaX() + lurkerParent.getDeltaX(), super.getYReal() + super.getDeltaY() + lurkerParent.getDeltaY());
		  setBounds(lurkerParent.getXReal(), lurkerParent.getXReal() + lurkerParent.getWidth());
		  
		  // Updates the x position of the boundary. Useful in case the parent is a platform.
		  if (super.getXReal() < lurkerMin)
		  {
			  super.setPosition(lurkerMin, super.getYReal() + super.getDeltaY() + lurkerParent.getDeltaY());
			  super.setVelocity(super.getDeltaX() * -1, super.getDeltaY());
		  }
		  else if (super.getXReal() + super.getWidth() > lurkerMax)
		  {
			  super.setPosition(lurkerMax - super.getWidth(), super.getYReal() + super.getDeltaY() + lurkerParent.getDeltaY());
			  super.setVelocity(super.getDeltaX() * -1, super.getDeltaY());
		  }
		  
		  // Updates the y position of the boundary. Useful in case the parent is an elevators.
		  if (super.getYReal() < lurkerMin)
		  {
			  super.setPosition(lurkerMin, super.getYReal() + super.getDeltaY() + lurkerParent.getDeltaY());
			  super.setVelocity(super.getDeltaX(), super.getDeltaY() * -1);
		  }
		  else if (super.getYReal() + super.getWidth() > lurkerMax)
		  {
			  super.setPosition(lurkerMax - super.getWidth(), super.getYReal() + super.getDeltaY() + lurkerParent.getDeltaY());
			  super.setVelocity(super.getDeltaX(), super.getDeltaY() * -1);
		  }
	  }
  }

}
