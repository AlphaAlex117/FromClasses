package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel4
{
	/**
	 * Population number of rabbits.
	 */
	private int populationRabbits = 500;
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel4()
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
    populationRabbits = populationRabbits / 2;
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    populationRabbits = 500;
  }
}
