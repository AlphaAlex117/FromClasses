package hw6;

import java.util.Scanner;

/*
 * Returns the binary version of a positive decimal number.
 * @author Alexander Lafontaine
 */
public class part5 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();

		String binaryNum = "";
		
		while (num >= 1)
		{
			binaryNum = (num % 2) + binaryNum;
			num /= 2;
		}
		
		System.out.println(binaryNum);
	}
}
