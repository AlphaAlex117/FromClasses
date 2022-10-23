package lab3;

public class Basketball
{
	
	private double ballDiameter = 0;
	private boolean isInflated = false;
	
	public Basketball(double givenDiameter)
	{
		ballDiameter = givenDiameter;
	}

	public boolean isDribbleable()
	{
		return isInflated;
	}

	public double getDiameter()
	{
		return ballDiameter;
	}

	public double getCircumference()
	{
		return 0;
	}

	public void inflate()
	{
		isInflated = true;
	}
}
