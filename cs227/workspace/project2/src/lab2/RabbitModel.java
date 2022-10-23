package lab2;

import java.util.Random;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel
{
	/**
	 * Population number of rabbits.
	 */
	private int populationRabbits = 0;
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel()
  {
    // TODO
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {
    return populationRabbits;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
	  
	Random rand = new Random();
	populationRabbits += rand.nextInt(10);
   
	
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    populationRabbits = 0;
  }
}
