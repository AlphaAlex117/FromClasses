package mini1;

import java.util.Scanner;

/**
 * Utility class with a bunch of static methods for loop practice.
 * @author smkautz
 */
public class Looperman
{

  // disable instantiation
  private Looperman() {}
  
  /**
   * Returns a string obtained from the given string by doubling all the vowels.
   * For example, given the string "Aardvark", the method returns "AAaardvaark".
   * @param s
   *   given string
   * @return
   *   a new string with all vowels doubled
   */
  public static String doubleAllVowels(String s)
  {
	  char ch = ' ';
	  String result = "";
	  for (int i = 0; i <= s.length() - 1; ++i)
	  {
		  ch = s.charAt(i);
		  if ("aeiouAEIOU".indexOf(ch) >= 0)
		  {
			  result = result + ch + "";
		  }
		  result = result + ch + "";
	  }
	  return result;
  }

  
  /**
   * Returns the number of iterations required until <code>n</code>
   * is equal to 1, where each iteration updates <code>n</code> in the following
   * way:
   * <pre>
   *     if n is even
   *         divide it in half
   *     else
   *         multiply n by three and add 1
   * </pre>
   * For example, given <code>n == 6</code>, the successive values
   * of <code>n</code> would be 3, 10, 5, 16, 8, 4, 2, 1, so the method returns 8.
   * If <code>n</code> is less than 1, the method returns -1.
   * <p>
   * <em>(Remark:</em> How do we know this won't be an infinite loop for some values of
   * <code>n</code>?  In general, we don't: in fact this is a well-known open problem in 
   * mathematics.  However, it has
   * been checked for numbers up to 10 billion, which covers the range of possible values 
   * of the Java <code>int</code> type.)  
   * @param n
   *     given starting number
   * @return
   *     number of iterations required to reach <code>n == 1</code>, or
   *     -1 if <code>n</code> is not positive
   */
  public static int collatzCounter(int n)
  {
	  if (n >= 1)
	  {
		  int count = 0;
		  for (count = 0; n != 1; ++count)
		  {
			  if (n % 2 == 0)
			  {
				  n = n / 2;
			  }
			  else
			  {
				  n = n * 3 + 1;
			  }
		  }
		  return count;
	  }
	  return -1;
  }
  
  
  /**
   * Given a string consisting of a name followed by numbers, returns a 
   * string consisting of the name, followed by a colon and space,
   * followed by the average of the numbers.  For example, given the string
   * <pre>
   * "Edna von Humboldt van der Scooch 10 20 30 40", 
   * </pre>
   * returns the string
   * <pre>
   * "Edna von Humboldt van der Scooch: 25.0"
   * </pre>
   * There is always at least one token for the name and at least one number.
   * The resulting string should have exactly one space between the parts of the name,
   * and should not have any leading or trailing spaces.
   * @param text
   *   string to be parsed
   * @return
   *   name followed by colon, space, and the average of the numbers
   */
  public static String parseNameNumbers(String text)
  {
	  Scanner input = new Scanner(text);
	  double average = 0.0;
	  String result = "";
	  int count = 0;
	  while (input.hasNext())
	  {
		  if (input.hasNextInt())
		  {
			  average += input.nextInt();
			  count += 1;
		  }
		  else
		  {
			  result = result + " " + input.next();
		  }
	  }
	  
	  result = result + ": " + (average / count);
	  result = result.trim();
	  input.close();
	  return result;
  }
  
  /**
   * Returns true if string t can be obtained from string s by inserting
   * exactly two characters.  For example, given "banana" and "bannanaa", 
   * the method returns true.
   * @param s
   *   shorter string
   * @param t
   *   longer string
   * @return
   *   true if you can insert two characters into s to make it equal t
   */
  public static boolean differByTwoInsertions(String s, String t)
  {
	  int sCount = 0;
	  int tCount = 0;
	  int flaws = 0;
	  while ((sCount <= s.length() - 1) && (tCount <= t.length() - 1))
	  {
		  if (s.charAt(sCount) == t.charAt(tCount))
		  {
			  tCount += 1;
			  sCount += 1;
		  }
		  else
		  {
			  flaws += 1;
			  tCount += 1;
		  }
	  }
	  flaws = flaws + (t.length() - tCount);
	  return flaws == 2;  
  }
  
  /**
   * Given a string, returns a new string in which text between 
   * the character '+' and the next '-' is converted to uppercase.
   * Any '+' characters encountered while converting to uppercase
   * are ignored, and likewise, any '-' characters encountered
   * without a corresponding preceding '+' are also ignored.
   * If a '+' is encountered that would ordinarily not be ignored, but
   * there is no matching '-' anywhere in the rest of the string, that 
   * '+' is ignored.
   * <p>
   * For example, 
   * <ul>
   * <li> given string "aa+rdv-ark" returns "aaRDVark"
   * <li> given string "aa+r++++dv-a+---+-+r-+k" returns "aaRDVaRk"
   * </ul>
   * @param s
   *   any string
   * @return
   *   new string in which text between matching '+' and '-' characters
   *   has been converted to uppercase
   */
  public static String plusMode(String s)
  {
	  String result = "";
	  String temporal = "";
	  int index = 0;
	  for (index = 0; index <= s.length() - 1; ++index) //Reads the string.
	  {
		  if (s.charAt(index) == '+') // If + sign:
		  {
			  while (s.charAt(index) != '-') // Iterate next variables as uppercase.
			  {
				  if (s.charAt(index) == '+') // If another + sign, skip it.
				  {
					  index += 1;
					  if (index == s.length()) // If end of string, break.
					  {
						  break;
					  }
					  continue;
				  }
				  
				  temporal = temporal + s.charAt(index);
				  index += 1;
				  
				  if (index == s.length()) // If end of string, break.
				  {
					  break;
				  }
			  }
		  }
		  else // If not a + sign:
		  {
			  if (s.charAt(index) != '-') // Check it isn't a - sign.
			  {
				  result = result + s.charAt(index);
			  }
		  }
		  
		  if (index == s.length()) // If end of string, break.
		  {
			  result = result + temporal;
			  temporal = "";
			  break;
		  }
		  
		  result = result + temporal.toUpperCase();
		  temporal = "";
	  }
	  return result;
  }
  
  /**
   * Returns a new string in which any vowel appearing by itself
   * is doubled, but groups of adjacent vowels are left alone.
   * For example, given the string "beautiful", returns "beautiifuul".
   * @param s
   *   any string
   * @return
   *   new string in which vowels are doubled, unless already part of a group
   *   of multiple vowels
   */
  public static String doubleVowelsMaybe(String s)
  {
	  char ch = ' ';
	  char ch1 = ' ';
	  char ch2 = ' ';
	  int i1 = 0;
	  int i2 = 0;
	  String result = "";
	  
	  for (int i = 0; i <= s.length() - 1; ++i) // Iterates through the string.
	  {
		  i1 = Math.max(0, i - 1);
		  i2 = Math.min(i + 1, s.length() - 1);
		  ch = s.charAt(i);
		  ch1 = s.charAt(i1);
		  ch2 = s.charAt(i2);
		  
		  if ("aeiouAEIOU".indexOf(ch) >= 0) // Checks if it is a vowel.
		  {
			  if (("aeiouAEIOU".indexOf(ch1) >= 0 && i != i1) || ("aeiouAEIOU".indexOf(ch2) >= 0 && i != i2)) //Check if previous letter is a vowel OR next letter is a vowel.
			  {
				  
			  }
			  else
			  {
				  result = result + ch + "";
			  }
		  }
		  result = result + ch + "";
	  }
	  return result;
  }
  
  
  

  /**
   * Prints a pattern of n rows containing slashes, backslashes, 
   * underscores and stars, as illustrated below for n = 6.  
   * Note that the bottom row starts and ends with exactly n underscores.
   * 
   * <pre>    
   *            /\
   *           /**\
   *          /****\
   *         /******\
   *        /********\
   * ______/**********\______
   * </pre>
   * 
   * @param n
   *   number of rows in the output
   */
  public static void witchHat(int n)
  {
	  String p = "/";
	  String q = "\\";
	  String r = "";
	  for (int line = 0; line <= n - 1; ++line) //Loops per line
	  {
		  if (line != n)
		  {
			  for (int stars = 0; stars < line * 2; ++stars)
			  {
				  p = p + "*";
			  }
			  
			  if (line == n - 1)
			  {
				  for (int underscores = n * 2 - 1; underscores >= 1 + line; --underscores) // Attaches backwards
				  {
					  
					  p = "_" + p;
				  }
				  
				  for (int underscores = n * 2 + 1; underscores <= n * 4 - 1 - line; ++underscores) //Attaches forward
				  {
					  q = q + "_";
				  }
				  
				  break;
			  }
			  
			  for (int spaces = n * 2 - 1; spaces >= 1 + line; --spaces) // Attaches backwards
			  {
				  
				  p = " " + p;
			  }
		  }

		  r = p + q;
		  System.out.println(r);
		  p = "/";
		  q = "\\";
		  r = "";
	  }
	  r = p + q;
	  System.out.println(r);
	  p = "/";
	  q = "\\";
	  r = "";
  }

}
