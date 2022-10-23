package hw6;

import java.util.Scanner;

/*
 * Returns the binary version of a positive decimal number.
 * @author Alexander Lafontaine
 */
public class part6 
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
		
		
		// -----------------------------------------------------------------
		
		
		// Adds a 0 in front of the number to fit with the hexadecimal substrings.
		while ((binaryNum.length() % 4) != 0)
		{
			binaryNum = 0 + binaryNum;
		}
		
		
		// Converts the binary number to hexadecimal.
		String preHexadecimal = "";
		String hexadecimal = "";
		int k = 0;
		while (k <= binaryNum.length() - 1)
		{
			preHexadecimal = binaryNum.substring(k, k + 4);
			k = k + 4;
			if (preHexadecimal.equals("0000"))
			{
				hexadecimal = hexadecimal + 0;
			}
			else if (preHexadecimal.equals("0001"))
			{
				hexadecimal = hexadecimal + 1;
			}
			else if (preHexadecimal.equals("0010"))
			{
				hexadecimal = hexadecimal + 2;
			}
			else if (preHexadecimal.equals("0011"))
			{
				hexadecimal = hexadecimal + 3;
			}
			else if (preHexadecimal.equals("0100"))
			{
				hexadecimal = hexadecimal + 4;
			}
			else if (preHexadecimal.equals("0101"))
			{
				hexadecimal = hexadecimal + 5;
			}
			else if (preHexadecimal.equals("0110"))
			{
				hexadecimal = hexadecimal + 6;
			}
			else if (preHexadecimal.equals("0111"))
			{
				hexadecimal = hexadecimal + 7;
			}
			else if (preHexadecimal.equals("1000"))
			{
				hexadecimal = hexadecimal + 8;
			}
			else if (preHexadecimal.equals("1001"))
			{
				hexadecimal = hexadecimal + 9;
			}
			else if (preHexadecimal.equals("1010"))
			{
				hexadecimal = hexadecimal + 'A';
			}
			else if (preHexadecimal.equals("1011"))
			{
				hexadecimal = hexadecimal + 'B';
			}
			else if (preHexadecimal.equals("1100"))
			{
				hexadecimal = hexadecimal + 'C';
			}
			else if (preHexadecimal.equals("1101"))
			{
				hexadecimal = hexadecimal + 'D';
			}
			else if (preHexadecimal.equals("1110"))
			{
				hexadecimal = hexadecimal + 'E';
			}
			else if (preHexadecimal.equals("1111"))
			{
				hexadecimal = hexadecimal + 'F';
			}
		}
		System.out.println(hexadecimal);
	}
}
