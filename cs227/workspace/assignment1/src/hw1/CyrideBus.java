package hw1;

/**
 * Class that models ridership and the location of a city bus.
 * @author Alexander Lafontaine
 *
 */
public class CyrideBus 
{
	
	/**
	 * Constant that designates when a bus is in the garage.
	 */
	public static final int BUS_GARAGE = -1;
	
	/**
	 * Stores the value of the busStop. Initialized at BUS_GARAGE.
	 */
	private int busStop = BUS_GARAGE;
	
	/**
	 * Stores total amount of stops.
	 */
	private int numTotalStops = 0;
	
	/**
	 * Stores the Service status. Initialized as bus is in service.
	 */
	private boolean inService = true;
	
	/**
	 * Stores the amount of passengers on board.
	 */
	private int numPassengers = 0;
	
	/**
	 * Stores the maximum capacity of the bus.
	 */
	private int maxCapacity = 0;
	
	/**
	 * Stores the current capacity of the bus.
	 */
	private int currentCapacity = 0;
	
	/**
	 * Stores the total amount of riders since the bus was constructed.
	 */
	private int totalRiders = 0;
	
	
	/**
	 * Constructs a new bus with the given maximum capacity and the amount of stops it will travel.
	 * @param givenMaxCapacity
	 * @param givenNumStops
	 */
	public CyrideBus(int givenMaxCapacity, int givenNumStops)
	{
		numTotalStops = givenNumStops;
		maxCapacity = givenMaxCapacity;
		currentCapacity = givenMaxCapacity;
		
	}
	
	/**
	 * Returns current capacity of the bus.
	 * @return currentCapacity
	 */
	public int getCurrentCapacity()
	{
		return currentCapacity;
	}
	
	/**
	 * Returns the current stop number.
	 * @return busStops
	 */
	public int getCurrentStop()
	{
		return busStop;
	}
	
	/**
	 * Returns the current number of passengers on the bus.
	 * @return numPassengers
	 */
	public int getNumPassengers()
	{
		return numPassengers;
	}
	
	/**
	 * Returns the total number of passengers who have gotten on this bus since it was constructed.
	 * @return totalRiders
	 */
	public int getTotalRiders()
	{
		return totalRiders;
	}
	
	/**
	 * Checks if the bus is in service.
	 * @return inService
	 */
	public boolean isInService()
	{
		return inService;
	}
	
	/**
	 * Simulates the bus traveling to its next stop.
	 * @param peopleOff
	 * @param peopleOn
	 */
	public void nextStop(int peopleOff, int peopleOn)
	{
		int seatsTaken;
		
		// Updates the bus stops and once it reaches the total amount, it returns to 0.
		busStop = (busStop + 1) % numTotalStops;
		
		// Seats taken by passengers are used to update the movement of passengers out of the bus.
		seatsTaken = numPassengers - peopleOff;
		numPassengers = Math.max(seatsTaken, 0);
		
		// Seats taken by passengers are used to update the movement of passengers into the bus.
		seatsTaken = numPassengers + peopleOn;
		// Brief intervention that counts the new people that entered the bus by
		// taking the max total of people that are using seats minus the people 
		// that were already in the bus that didn't get off.
		totalRiders = totalRiders + (Math.min(seatsTaken, currentCapacity) - numPassengers);
		numPassengers = Math.min(seatsTaken, currentCapacity);
		
	}
	
	/**
	 * Places current bus on service and sets its capacity to the maximum value.
	 */
	public void placeInService()
	{
		currentCapacity = maxCapacity;
		inService = true;
	}
	
	/**
	 * Takes current bus off service and sets its capacity to zero, all passengers get off and the bus is teleported to BUS_GARAGE.
	 */
	public void removeFromService()
	{
		numPassengers = 0;
		currentCapacity = 0;
		busStop = BUS_GARAGE;
		inService = false;
	}

}
