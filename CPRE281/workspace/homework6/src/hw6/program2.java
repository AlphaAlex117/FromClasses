package hw6;
import java.util.Scanner;

/*
 * Program to converts a decimal number into binary.
 * @author Alexander Lafontaine
 */
public class program2 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		double num = input.nextDouble();
		input.close();
		
		// Checks if the number is negative.
		int sign = 0;
		if (num < 0)
		{
			sign = 1;
		}
		
		// This whole section prepares the numbers for the algorithm by
		// making it positive and separating the whole from the decimal.
		num = Math.abs(num);
		int count = (int)num;
		double decimal = num - count;
		int exponent = -1;
		int bit = 0;
		String mantissa = "";
		
		// Finds the Mantissa part but from the integer.
		while (count >= 1)
		{
			bit = count % 2;
			count /= 2;
			if (count > 0)
			{
				mantissa = bit + mantissa;
			}
			exponent = exponent + 1;
		}
		
		int remove = 0;
		String add = "";
		
		// Finds the Mantissa part but from the decimal.
		for (int i = 1; i <= 32; ++i)
		{
			decimal = decimal * 2;
			remove = (int)decimal;
			add = (add + remove);
			decimal = decimal - remove;
		}
		
		String binary = "";
		mantissa = mantissa + add;
		exponent = exponent + 127;
		
		// Finds the Exponent part of the IEEE.
		if (exponent >= 128)
		{
			while (exponent >= 1)
			{
				bit = exponent % 2;
				exponent /= 2;
				binary = bit + binary;
			}
		}
		else
		{
			while (exponent >= 1)
			{
				bit = exponent % 2;
				exponent /= 2;
				binary = bit + binary;
			}
			
			while (binary.length() - 1 < 7)
			{
				binary = 0 + binary;
			}
		}
		
		
		// Combines every collected part
		binary = sign + binary + mantissa;
		
		
		String finalBinaryNum = "";
		
		// Filter binary number to a 32 bit limit.
		for (int limit = 0; limit < 32; ++limit)
		{
			finalBinaryNum = finalBinaryNum + binary.charAt(limit);
		}
		
		
		// -----------------------------------------------------------------
		
		// Converts the binary number to hexadecimal.
		String preHexadecimal = "";
		String hexadecimal = "";
		int k = 0;
		while (k <= finalBinaryNum.length() - 1)
		{
			preHexadecimal = finalBinaryNum.substring(k, k + 4);
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
