package exam1;

public class Airplane
{
	
	private int maxSeats = 0;
	
	private int numPassengers = 0;
	
	private int maxBags = 0;
	
	private int numBags = 0;
	
	private double totalMilesTraveled = 0.0;
	
	private boolean inService = true;
	
	public Airplane(int maxPassengers, int maxLuggage)
	{
		maxSeats = maxPassengers;
		maxBags = maxLuggage;
	}
	
	public int getNumPassengers()
	{
		return numPassengers;
	}
	
	public int getNumBags()
	{
		return numBags;
	}
	
	public void fly(int passengers, int bags, double milesTraveled)
	{
		numPassengers = Math.min(passengers, maxSeats);
		numBags = Math.min(bags, maxBags);
		
	}
}
