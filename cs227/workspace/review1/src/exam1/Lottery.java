package exam1;
import java.util.Random;
import java.util.Scanner;

public class Lottery
{
	private int maxNumbers;
	
	public Lottery(int possibleAmountOutcomes)
	{
		maxNumbers = possibleAmountOutcomes;
	}
	
	public void play()
	{
		Random random = new Random();
		Scanner input = new Scanner(System.in);
		
		int num = random.nextInt(maxNumbers);
		System.out.print("Enter a number from 0 to " + (maxNumbers - 1) + ": ");
		int answer = input.nextInt();
		
		if (num == answer)
		{
			System.out.println("You WIN");
		}
		else
		{
			System.out.println("You LOSE");
		}
	}
}
