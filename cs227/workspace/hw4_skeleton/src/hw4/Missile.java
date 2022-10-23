package hw4;

/**
 * Moving element in which the vertical velocity is adjusted
 * each frame by a gravitational constant to simulate gravity.
 * It may also be put into a "ballistic" state in which 
 * no other modifications to velocity take place other than gravity.
 * 
 * @author Alexander Lafontaine
 */
public class Missile extends MovingElement
{
	/**
	 * Stores where Missile is ballistic or not.
	 */
	private boolean ballisticMissile = false;
	
	private double ballisticGravity = 0.0;
	
  /**
   * Constructs a new Missile.
   * @param x
   *   x-coordinate of upper left corner
   * @param y
   *   y-coordinate of upper left corner
   * @param width
   *   element's width
   * @param height
   *   element's height
   */
  public Missile(double x, double y, int width, int height)
  {
	  super(x, y, width, height);
  }

  /**
   * Returns whether the Missile is ballistic or not.
   * @return ballisticMissile
   */
  public boolean isBallistic()
  {
	  return ballisticMissile;
  }
  
  /**
   * Sets the ballistic status of the missile.
   * @param ballistic
   */
  public void setBallistic(boolean ballistic)
  {
	  ballisticMissile = ballistic;
  }
  
  /**
   * Sets the gravity for the ballistic missile.
   * @param gravity
   */
  public void setGravity(double gravity)
  {
	  ballisticGravity = gravity;
  }
  
  /**
   * Updates the positions and the y velocity. Also counts a frame. 
   */
  @Override
  public void update()
  {
	  addFrameCount();
	  super.setPosition(getXReal() + getDeltaX(), getYReal() + getDeltaY());
	  super.setVelocity(getDeltaX(), getDeltaY() + ballisticGravity);
  }
}
