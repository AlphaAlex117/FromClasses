
package hw4;

/**
 * Implementation of GameElement that does not move. Instead, it is intended to
 * appear on the screen for a fixed number of frames.
 * 
 * @author Alexander Lafontaine
 */
public class Flash extends BasicElement
{
	/**
	 * Stores the amount of life of the flash.
	 */
	private int flashLife = 0;
	
  /**
   * Constructs a new Flash.
   * 
   * @param x
   *          x-coordinate of upper left corner
   * @param y
   *          y-coordinate of upper left corner
   * @param width
   *          element's width
   * @param height
   *          element's height
   * @param initialLife
   *          the number of frames until this element marks itself for deletion
   */
  public Flash(double x, double y, int width, int height, int initialLife)
  {
	  super(x, y, width, height);
	  flashLife = initialLife;
  }
  
  /**
   * Returns the remaining life of the flash.
   * @return elementLife
   */
  public int getRemainingLife()
  {
	  return flashLife;
  }
  
  /**
   * Updates the flash by taking off a life point and then marking it 
   * for deletion after hitting zero. Also updates the frame count.
   */
  @Override
  public void update()
  {
	  addFrameCount();
	  flashLife -= 1;
	  if (flashLife <= 0)
	  {
		  super.markForDeletion();
	  }
  }

}
