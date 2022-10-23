package exam2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class questionOne
{

	public static void main(String[] args)
	{
		System.out.println(longestWord("Today is a great day to be outside"));
		System.out.println(replacedCharacters("Hello, World!"));
		System.out.println(firstVowel("BRR"));
		reverseStars(5);
		System.out.println(smallestPrime(9));

		int[] test1 = { 5, 4, 5, 6, 4, 2 };
		collapse(test1);
		for (int i = 0; i < test1.length; ++i) {
			System.out.print(test1[i] + " ");
		}
		System.out.println();

		int[] test2 = { 5, 4, 5, 6, 4, 2 };
		int[] result2 = collapseNew(test2);
		for (int i = 0; i < result2.length; ++i) {
			System.out.print(result2[i] + " ");
		}
		System.out.println();

		ArrayList<Integer> result3 = randomNumbers();
		for (int i = 0; i < result3.size(); ++i) {
			System.out.print(result3.get(i) + " ");
		}
		System.out.println();

		System.out.println(reverseWords("My name is Giovanni Giorgio, but everybody call me... Giorgio."));
		
		int[] test4 = { 5, 4, 5, 6, 4, 2};
		reverseHalfs(test4);
		for (int i = 0; i < test4.length; ++i) {
			System.out.print(test4[i] + " ");
		}
		System.out.println();

	}

	// 1a
	public static double average(double[] arr)
	{
		double result = 0;
		for (int i = 0; i < arr.length; ++i) {
			result = result + arr[i];
		}
		return result / arr.length;
	}

	// 1b
	public static String longestWord(String sentence)
	{
		String[] wordList = sentence.split(" ");
		String word = wordList[0];
		for (int i = 1; i < wordList.length; ++i) {
			if (word.length() < wordList[i].length()) {
				word = wordList[i];
			}
		}
		return word;
	}

	// 1c
	public static String replacedCharacters(String str)
	{
		String result = "";
		for (int i = 0; i < str.length(); ++i) {
			if (Character.isAlphabetic(str.charAt(i)) == true) {
				result = result + str.charAt(i);
			} else {
				result = result + "#";
			}
		}
		return result;
	}

	// 1d

	// 1e
	public static boolean isIncreasingOrder(ArrayList<Integer> listOfNumbers)
	{
		for (int i = 1; i < listOfNumbers.size(); ++i) {
			Integer firstNumber = listOfNumbers.get(i - 1);
			Integer secondNumber = listOfNumbers.get(i);
			if (firstNumber.compareTo(secondNumber) > 0) {
				return false;
			}
		}
		return true;
	}

	// 1f
	public static int firstVowel(String str)
	{
		for (int i = 0; i < str.length(); ++i) {
			if ("AEIOUaeiou".indexOf(str.charAt(i)) != -1) {
				return i;
			}
		}
		return -1;
	}

	// 1g
	public static boolean isTwoOrMore(String str)
	{
		for (int i = 0; i < str.length(); ++i) {
			for (int j = 0; j < str.length() && i != j; ++j) {
				if (str.charAt(i) == str.charAt(j)) {
					return true;
				}
			}
		}
		return false;
	}

	// 1h
	public static void reverseArray(int[] arr)
	{
		for (int i = 0; i < arr.length / 2; ++i) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
	}

	// 1i
	public static boolean isPermutation(int[] arr)
	{
		int index = 0;
		for (int num = 0; num < arr.length; ++num) {
			for (index = 0; index < arr.length; ++index) {
				if (num == arr[index]) {
					break;
				}
			}
			if (num == arr[index]) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	// 1j
	public static void reverseStars(int n)
	{
		for (int star = 0; star < n; ++star) {
			for (int space = n - 1 - star; space >= 0; --space) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
	}

	// 1k
	public static double[] columnAverage(double[][] arr)
	{
		double[] result = new double[arr[0].length];
		double sum = 0.0;
		for (int col = 0; col < arr[0].length; ++col) {
			for (int row = 0; row < arr.length; ++row) {
				sum = sum + arr[row][col];
			}
			result[col] = sum / arr.length;
			sum = 0.0;
		}
		return result;
	}

	// 1l
	public static int colMaxSum(int[][] arr)
	{
		int sum = 0;
		int max = 0;
		int index = 0;
		for (int col = 0; col < arr[0].length; ++col) {
			for (int row = 0; row < arr.length; ++row) {
				sum = sum + arr[row][col];
			}
			if (max <= sum) {
				index = col;
				max = sum;
			}

		}
		return index;
	}

	// 1m
	public static int[][] whArr(int w, int h, int[] arr)
	{
		int[][] result = new int[h][w];
		int count = 0;
		for (int row = 0; row < result.length; ++row) {
			for (int col = 0; col < result[0].length; ++col) {
				result[row][col] = arr[count];
				count += 1;
			}
		}
		return result;
	}

	// 1n
	public static int smallestPrime(int n)
	{
		int result = 0;
		// TODO
		return result;
	}

	// 1o
	public static void collapse(int[] arr)
	{
		ArrayList<Integer> organizer = new ArrayList<>();
		organizer.add(arr[0]);
		for (int index = 1; index < arr.length; ++index) {
			boolean flag = false;
			for (int indexList = 0; indexList < organizer.size(); ++indexList) {
				if (organizer.get(indexList) == arr[index]) {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				organizer.add(arr[index]);
			}
		}
		for (int index = 0; index < arr.length; ++index) {
			if (index < organizer.size()) {
				int temp = organizer.get(index);
				arr[index] = temp;
			} else {
				arr[index] = 0;
			}
		}
	}

	// 1p
	public static int[] collapseNew(int[] arr)
	{
		ArrayList<Integer> organizer = new ArrayList<>();
		organizer.add(arr[0]);
		for (int index = 1; index < arr.length; ++index) {
			boolean flag = false;
			for (int indexList = 0; indexList < organizer.size(); ++indexList) {
				if (organizer.get(indexList) == arr[index]) {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				organizer.add(arr[index]);
			}
		}
		int[] result = new int[organizer.size()];
		for (int index = 0; index < result.length; ++index) {
			int temp = organizer.get(index);
			result[index] = temp;
		}
		return result;
	}

	// 1q
	public static ArrayList<Integer> randomNumbers()
	{
		Random rand = new Random();
		boolean flag = true;
		ArrayList<Integer> result = new ArrayList<>();
		while (flag == true) {
			Integer num = rand.nextInt(100);
			if (result.contains(num)) {
				flag = false;
				break;
			}
			result.add(num);
		}
		return result;
	}

	// 1r
	public static String reverseWords(String str)
	{
		Scanner scan = new Scanner(str);
		String result = "";
		while (scan.hasNext()) {
			result = scan.next() + " " + result;
		}
		scan.close();
		return result;
	}

	// 1s
	public static void reverseHalfs(int[] arr)
	{
		int temp = 0;
		for (int index = 0; index < arr.length / 2; ++index) {
			if (arr.length % 2 == 0)
			{
				temp = arr[index];
				arr[index] = arr[(arr.length / 2) + index];
				arr[(arr.length / 2) + index] = temp;
			}
			else
			{
				temp = arr[index];
				arr[index] = arr[(arr.length / 2) + 1 + index];
				arr[(arr.length / 2) + 1 + index] = temp;
			}
		}	
	}
}
