package hw6;

import java.util.Scanner;

/*
 * @author Alexander Lafontaine
 */
public class part8 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		String binaryNum = input.next();
		input.close();
		
		int decimalNum = 0;
		int bit = 7;
				
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
