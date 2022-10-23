package hw4;

import java.util.ArrayList;
import api.GameElement;

/**
 * A Platform is a GameElement with two distinctive behaviors.  First,
 * it can be set up to move horizontally within a fixed set of boundaries.
 * On reaching a boundary, the x-component of its velocity is reversed.
 * Second, it maintains a list of <em>child</em> elements whose basic
 * motion all occurs relative to the Platform.
 * 
 * @author Alexander Lafontaine
 */
public class Platform extends MovingElement
{
	/**
	 * Stores the left boundary of the platform.
	 */
	private double minBound = Double.NEGATIVE_INFINITY;
	
	/**
	 * Stores the right boundary of the platform.
	 */
	private double maxBound = Double.POSITIVE_INFINITY;
	
	/**
	 * Stores the list of children linked to the platform.
	 */
	private ArrayList<GameElement> childrenList = new ArrayList<>();
	
  /**
   * Constructs a new Platform. Initially the left and right
   * boundaries are <code>Double.NEGATIVE_INFINITY</code> and
   * <code>Double.POSITIVE_INFINITY</code>, respectively.
   * @param x
   *   x-coordinate of initial position of upper left corner
   * @param y
   *   y-coordinate of initial position of upper left corner
   * @param width
   *   object's width
   * @param height
   *   object's height
   */
  public Platform(double x, double y, int width, int height)
  {
    super(x, y, width, height);
  }

  /**
   * Sets the bounds of the platform.
   * @param min
   * @param max
   */
  public void setBounds(double min, double max)
  {
	  minBound = min;
	  maxBound = max;
  }
  
  /**
   * Returns the minimum bound.
   * @return minBound
   */
  public double getMin()
  {
	  return minBound;
  }
  
  /**
   * Returns the maximum bound.
   * @return maxBound
   */
  public double getMax()
  {
	  return maxBound;
  }
  
  /**
   * Updates the frame count and the position. If the position goes beyond the left
   * boundary, it returns to the edge of the boundary. If the the position goes
   * the right boundary, it returns to edge of the boundary. It also updates
   * all the children in the list of children.
   */
  @Override
  public void update()
  {
	  addFrameCount();
	  super.setPosition(super.getXReal() + super.getDeltaX(), super.getYReal() + super.getDeltaY());
	  if (super.getXReal() < minBound)
	  {
		  super.setPosition(minBound, super.getYReal() + super.getDeltaY());
		  super.setVelocity(super.getDeltaX() * -1, super.getDeltaY());
	  }
	  else if (super.getXReal() + super.getWidth() > maxBound)
	  {
		  super.setPosition(maxBound - super.getWidth(), super.getYReal() + super.getDeltaY());
		  super.setVelocity(super.getDeltaX() * -1, super.getDeltaY());
	  }
	  for (GameElement child : childrenList)
	  {
		  child.update();
	  }
  }
  
  /**
   * Adds a charm element to the list of children.
   * @param charm
   */
  public void addChild(Charm charm)
  {
	  childrenList.add(charm);
	  charm.setParent(this);
  }
  
  /**
   * Adds a lurker element to the list of children.
   * @param lurker
   */
  public void addChild(Lurker lurker)
  {
	  childrenList.add(lurker);
	  lurker.setParent(this);
  }
  
  /**
   * Removes any marked children from the children list.
   */
  public void deleteMarkedChildren()
  {
	  int index = 0;
	  while (index < childrenList.size())
	  {
		  if (childrenList.get(index).isMarked())
		  {
			  childrenList.remove(index);
		  }
		  else
		  {
			  index += 1;
		  }
	  }
  }
  
  /**
   * Returns the list of children.
   * @return childrenList
   */
  public ArrayList<GameElement> getChildren()
  {
	  return childrenList;
  }
}
