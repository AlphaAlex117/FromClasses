package exam3;
import java.util.ArrayList;

public class ExerciseOneA
{

	public static int RecursiveMethod(int numBricks)
	{
		if (numBricks < 0)
		{
			return 0;
		}
		else if (numBricks == 0)
		{
			return 1;
		}
		else
		{
			return RecursiveMethod(numBricks - 1) + RecursiveMethod(numBricks - 2) + RecursiveMethod(numBricks - 3);
		}
	}
	
	public static ArrayList<String> SecondMethod(int numBricks, String path)
	{
		ArrayList<String> differentPaths = new ArrayList<>();
		
		if (numBricks < 0)
		{
			// Doesn't do anything
		}
		else if(numBricks == 0)
		{
			differentPaths.add(path);
		}
		else
		{
			SecondMethod(numBricks - 1, path + "1");
			SecondMethod(numBricks - 2, path + "2");
			SecondMethod(numBricks - 3, path + "3");
		}
		
		return differentPaths;
	}
	
	public static void main(String[] args)
	{
		System.out.println(RecursiveMethod(3));
		
		ArrayList<String> list = SecondMethod(4, "");
		
		for (String path : list)
		{
			System.out.println(path);
		}
	}

}
