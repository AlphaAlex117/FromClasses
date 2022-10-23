package lab7;

public class BricksCount
{

	public static void main(String[] args)
	{
		int count = brickPattern(10);
		System.out.println(count);
	}
	
	public static int brickPattern(int n)
	{
		int count = 0;
		if (n < 0)
		{
			return 0;
		}
		else if (n == 0)
		{
			return 1;
		}
		else
		{
			count = count + brickPattern(n - 1) + brickPattern(n - 3);
			return count;
		}
	}

}
