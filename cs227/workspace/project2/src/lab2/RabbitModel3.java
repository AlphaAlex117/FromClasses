package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel3
{
	/**
	 * Population number of rabbits.
	 */
	private int populationRabbits = 0;
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel3()
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
    populationRabbits = (populationRabbits + 1) % 5;
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
