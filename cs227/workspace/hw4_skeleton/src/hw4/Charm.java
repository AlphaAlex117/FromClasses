
package hw4;

import api.GameElement;

/**
 * Element associated with parent object such as a Platform or Elevator
 * that moves along with the parent and remains a fixed distance above it.
 * 
 * @author Alexander Lafontaine
 */
public class Charm extends BasicElement
{
	/**
	 * Stores the charm's offset value.
	 */
	private int charmOffset = 0;
	
	/**
	 * Stores the charm's hover value.
	 */
	private int charmHover = 0;
	
	/**
	 * Stores this charm's parent.
	 */
	private GameElement parentElement;
	
  /**
   * Constructs a new Charm.  Before being added to a parent element
   * such as a Platform or Elevator, the x and y coordinates are zero.  
   * When a parent object is set, the initial x-coordinate becomes
   * the parent's x-coordinate, plus the given offset, and the y-coordinate
   * becomes the parent's y-coordinate, minus this element's height, minus
   * the hover amount.
   * @param width
   *   element's width
   * @param height
   *   element's height
   * @param offset
   *   when a parent is set, this amount is added to the parent's x-coordinate
   *   to calculate this element's x-coordinate
   * @param hover
   *   when a parent is set, this element's y-coordinate is the parent's
   *   y-coordinate, minus this element's height, minus the hover amount
   */
  public Charm(int width, int height, int offset, int hover)
  {
	  super(0, 0, width, height);
	  charmOffset = offset;
	  charmHover = hover;
  }
  
  /**
   * Sets the element as this child's parent.
   * @param p
   */
  public void setParent(GameElement p)
  {
	  parentElement = p;
	  super.setPosition(charmOffset + parentElement.getXReal(), parentElement.getYReal() - super.getHeight() - charmHover);
  }
  
  /**
   * Updates the frame count and the position relative to its parent object.
   */
  @Override
  public void update()
  {
	  addFrameCount();
	  if (parentElement != null)
	  {
		  super.setPosition(charmOffset + parentElement.getXReal(), parentElement.getYReal() - super.getHeight() - charmHover);
	  }
  }

}
