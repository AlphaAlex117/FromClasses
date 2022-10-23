package mini2;

public class SunshineTest
{

	public static void main(String[] args)
	{
		String[] list1 = {"foo", "four", "football"};
		String test1 = ArrayOfSunshine.longestCommonPrefix(list1);
		System.out.println(test1);
		System.out.println("Expected: fo");
		
		System.out.println("----------------------------------------------");
		
		// Even
		int[] list2 = {2, 4, 6, 1, 2, 3};
		ArrayOfSunshine.swapFirstLast(list2);
		for (int i = 0; i < list2.length; ++i)
		{
			System.out.print(list2[i] + ", ");
		}
		System.out.println();
		System.out.println("Expected: 1, 2, 3, 2, 4, 6");
		// Odd
		int[] list3 = {2, 4, 6, 99, 1, 2, 3};
		ArrayOfSunshine.swapFirstLast(list3);
		for (int i = 0; i < list3.length; ++i)
		{
			System.out.print(list3[i] + ", ");
		}
		System.out.println();
		System.out.println("Expected: 1, 2, 3, 99, 2, 4, 6");

		System.out.println("----------------------------------------------");
		
		int[] sizzler = {3, 0, 3, 1};
		int[] list4 = {10, 20, 30, 40};
		ArrayOfSunshine.swizzle(list4, sizzler);
		for (int i = 0; i < sizzler.length; ++i)
		{
			System.out.print(list4[i] + ", ");
		}
		System.out.println();
		System.out.println("Expected: 40, 10, 40, 20");
		
		System.out.println("----------------------------------------------");
		
		int[] list5 = {1, 2, 3, 4, 5, 6, 7};
		int[] resultList = ArrayOfSunshine.condense(list5, 3);
		for (int i = 0; i < resultList.length; ++i)
		{
			System.out.print(resultList[i] + ", ");
		}
		System.out.println();
		System.out.println("Expected: 6, 15");
		
		System.out.println("----------------------------------------------");
		
		int[] list6 = {2, 4, 0, 1, 3};
		int[] resultList2 = ArrayOfSunshine.findOneCycle(list6, 3);
		for (int i = 0; i < resultList2.length; ++i)
		{
			System.out.print(resultList2[i] + ", ");
		}
		System.out.println();
		System.out.println("Expected: 3, 1, 4");
	}

}
