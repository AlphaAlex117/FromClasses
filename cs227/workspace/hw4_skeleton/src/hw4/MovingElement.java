package hw4;

/**
 * Concrete implementation of GameElement in which the <code>update</code>
 * method updates the position each frame according to a <em>velocity</em> 
 * vector (deltaX, deltaY).  The units are assumed to be "pixels per frame".
 * 
 * @author Alexander Lafontaine
 */
public class MovingElement extends BasicElement
{

	private double elementDeltaX = 0.0;
	
	private double elementDeltaY = 0.0;
	
  /**
   * Constructs a MovingElement with a default velocity of zero in
   * both directions.
   * @param x
   *   x-coordinate of upper left corner
   * @param y
   *   y-coordinate of upper left corner
   * @param width
   *   object's width
   * @param height
   *   object's height
   */
  public MovingElement(double x, double y, int width, int height)
  {
	  super(x, y, width, height);
  }
  
  /**
   * Sets the velocity of the moving element.
   * @param deltaX
   * @param deltaY
   */
  public void setVelocity(double deltaX, double deltaY)
  {
	  elementDeltaX = deltaX;
	  elementDeltaY = deltaY;
  }
  
  /**
   * Returns the value of delta x.
   * @return
   */
  public double getDeltaX()
  {
	  return elementDeltaX;
  }
  
  /**
   * Returns the value of delta y.
   * @return
   */
  public double getDeltaY()
  {
	  return elementDeltaY;
  }
  
  /**
   * Updates the position with the delta values. Also updates the frame count.
   */
  @Override
  public void update()
  {
	  addFrameCount();
	  super.setPosition(super.getXReal() + getDeltaX(), super.getYReal() + getDeltaY());
  }
}
