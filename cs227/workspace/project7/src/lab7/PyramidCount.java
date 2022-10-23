package lab7;

public class PyramidCount
{

	public static void main(String[] args)
	{
		int volumeCount = getPyramidCount(7);
		System.out.println(volumeCount);
	}
	
	public static int getPyramidCount(int height)
	{
		if (height == 1)
		{
			return 1;
		}
		else
		{
			int areaCount = getPyramidCount(height - 1);
			return height * height + areaCount;
		}
		
	}

}
