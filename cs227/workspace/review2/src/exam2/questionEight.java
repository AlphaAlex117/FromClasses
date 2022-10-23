package exam2;

public class questionEight
{
	public static void main(String[] args)
	{
		int[] test = {0, 1, 2, 3, 4, 5};
		int[] test2 = {1, 3, 5, 7, 8};
		int[] test3 = {2, 3, 5, 1, 2, 3};
		int[] test4 = {1, 1, 1, 1};
		System.out.println(whoKnows(test));
		System.out.println(whoKnows(test2));
		System.out.println(whoKnows(test3));
		System.out.println(whoKnows(test4));
	}
	
	public static boolean whoKnows(int[] arr)
	{
		for (int i = 1; i < arr.length; ++i)
		{
			if (arr[i - 1] > arr[i])
			{
				return false;
			}
		}
		return true;
	}
}
