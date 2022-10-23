package hw6;

import java.util.Scanner;

/*
 * @author Alexander Lafontaine
 */
public class part9 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		String binaryNum = input.next();
		input.close();
		
		int decimalNum = 0;
		String reverseBinary = "";
		int bit = 7;
	
		for (int j = 0; j <= binaryNum.length() - 1; ++j)
		{
			reverseBinary = binaryNum.charAt(j) + reverseBinary;
		}
		
		boolean firstOne = false;
		String reverseNegatedBinary = "";
		
		for (int k = 0; k <= reverseBinary.length() - 1; ++k)
		{
			if (reverseBinary.charAt(k) == '1' && firstOne == false)
			{
				reverseNegatedBinary = reverseNegatedBinary + 1;
				firstOne = true;
			}
			else if (reverseBinary.charAt(k) == '0' && firstOne == false)
			{
				reverseNegatedBinary = reverseNegatedBinary + 0;
			}
			else if (reverseBinary.charAt(k) == '1' && firstOne == true)
			{
				reverseNegatedBinary = reverseNegatedBinary + 0;
			}
			else if(reverseBinary.charAt(k) == '0' && firstOne == true)
			{
				reverseNegatedBinary = reverseNegatedBinary + 1;
			}
		}
		
		String negatedBinary = "";
		
		for (int j = 0; j <= reverseNegatedBinary.length() - 1; ++j)
		{
			negatedBinary = reverseNegatedBinary.charAt(j) + negatedBinary;
		}
		
		
		// -------------------------------------------------------------
		
		
		if (binaryNum.charAt(0) == '0')
		{
			for (int i = 1; i <= binaryNum.length() - 1; ++i)
			{	
				if (binaryNum.charAt(i) == '1')
				{
					decimalNum = decimalNum + (int)Math.pow(2, (binaryNum.length() - 1) - i);
				}
			}
		}
		else if (binaryNum.charAt(0) == '1')
		{
			for (int i = 1; i <= binaryNum.length() - 1; ++i)
			{	
				if (binaryNum.charAt(i) == '1')
				{
					decimalNum = decimalNum + (int)Math.pow(2, (binaryNum.length() - 1) - i);
				}
			}
			decimalNum = -1 * ((int)Math.pow(2, bit) - decimalNum);
		}
		
		System.out.println(decimalNum);
		
	}
}
