package hw4;

import api.GameElement;

/**
 * An Elevator is a GameElement with two distinctive behaviors.  First,
 * it can be set up to move vertically within a fixed set of boundaries.
 * On reaching a boundary, the y-component of its velocity is reversed.
 * Second, it maintains a list of <em>child</em> elements whose basic
 * motion all occurs relative to the Elevator.
 * 
 * @author Alexander Lafontaine
 */
public class Elevator extends Platform
{
  
  /**
   * Constructs a new Elevator.  Initially the upper and lower
   * boundaries are <code>Double.NEGATIVE_INFINITY</code> and
   * <code>Double.POSITIVE_INFINITY</code>, respectively.
   * @param x
   *   x-coordinate of initial position of upper left corner
   * @param y
   *   y-coordinate of initial position of upper left corner
   * @param width
   *   element's width
   * @param height
   *   element's height
   */
  public Elevator(double x, double y, int width, int height)
  {
    super(x, y, width, height);
  }
  
  /**
   * Similar to platform's update method but this one updates the y coordinates and
   * velocities. 
   */
  @Override
  public void update()
  {
	  addFrameCount();
	  super.setPosition(super.getXReal() + super.getDeltaX(), super.getYReal() + super.getDeltaY());
	  if (super.getYReal() < super.getMin())
	  {
		  super.setPosition(super.getYReal() + super.getDeltaY(), super.getMin());
		  super.setVelocity(super.getDeltaX(), super.getDeltaY() * -1);
	  }
	  else if (super.getXReal() + super.getWidth() > super.getMax())
	  {
		  super.setPosition(super.getXReal() + super.getDeltaX(), super.getMax() - super.getHeight());
		  super.setVelocity(super.getDeltaX(), super.getDeltaY() * -1);
	  }
	  for (GameElement child : super.getChildren())
	  {
		  child.update();
	  }
  }
  
}
