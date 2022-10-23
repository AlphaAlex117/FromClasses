package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel5
{
	/**
	 * Population number of rabbits.
	 */
	private int populationRabbits = 1;
	
	/**
	 * Population number of rabbits the last year.
	 */
	private int lastYear = 1;
	
	/**
	 * Population number of rabbits the year before.
	 */
	private int yearBefore = 0;
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel5()
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
	populationRabbits = lastYear + yearBefore;
	yearBefore = lastYear;
	lastYear = populationRabbits;
   
   
	
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    populationRabbits = 1;
    lastYear = 1;
    yearBefore = 0;
  }
}
