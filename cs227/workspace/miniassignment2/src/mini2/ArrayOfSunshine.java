package mini2;

import java.util.ArrayList;

public class ArrayOfSunshine
{
  
  // disable instantiation
  private ArrayOfSunshine() {}
  
  /**
   * Returns the longest string that is a prefix of
   * all strings in the given array.  For example, 
   * if the array is ["foo", "four", "football"], the
   * method returns "fo".  If the array is empty, returns
   * an empty string.
   * @param arr
   *   any array of strings.
   * @return
   *   longest common prefix of the given strings
   */
  public static String longestCommonPrefix(String[] arr)
  {
	  String prefix = "";
	  String firstWord = "";
	  //Iterates through array.
	  for (int arrayIndex = 1; arrayIndex < arr.length; ++arrayIndex) 
	  {
		  if (arrayIndex == 1)
		  {
			  firstWord = arr[0];
		  }
		  String comparisonWord = arr[arrayIndex];
		  
		  //Iterates through string.
		  for (int i = 0; i < firstWord.length() && i < comparisonWord.length(); ++i)
		  {
			  if (firstWord.charAt(i) == comparisonWord.charAt(i))
			  {
				  prefix = prefix + firstWord.charAt(i);
			  }
		  }
		  firstWord = prefix;
		  if (arrayIndex == arr.length - 1)
		  {
			  break;
		  }
		  prefix = "";
	  }
	  if (arr.length == 1)
	  {
		  prefix = arr[0];
	  }
	  return prefix;
  }
  
  /**
   * Modifies the given array by exchanging the first half
   * with the second half.  If the array has odd length, the
   * center element is not moved.  For example, given array
   * <pre>
   * [2, 4, 6, 99, 1, 2, 3]
   * </pre>
   * after swapFirstLast the array
   * contains
   * <pre>
   * [1, 2, 3, 99, 2, 4, 6]
   * </pre>
   * Note this method modifies the given array and returns
   * void.
   * @param arr
   *   the int array to be modified
   */
  public static void swapFirstLast(int[] arr)
  {
	  if (arr.length % 2 == 0) 
	  {
		  for (int evenIndex = 0; evenIndex < arr.length / 2; ++evenIndex)
		  {
			  int tempVal1 = arr[evenIndex];
			  int tempVal2 = arr[arr.length / 2 + evenIndex];
			  arr[evenIndex] = tempVal2;
			  arr[arr.length / 2 + evenIndex] = tempVal1;
		  }
	  }
	  else
	  {
		  for (int oddIndex = 0; oddIndex < arr.length / 2; ++oddIndex)
		  {
			  int tempVal1 = arr[oddIndex];
			  int tempVal2 = arr[arr.length / 2 + 1 + oddIndex];
			  arr[oddIndex] = tempVal2;
			  arr[arr.length / 2 + 1 + oddIndex] = tempVal1;
		  }
	  }
  }
  
  /**
   * Rearrange the elements of arr according to the given list of
   * indices.  After calling this method, arr[i] should be
   * the value formerly located at arr[swizzler[i]].
   * For example, if swizzler is [3, 0, 3, 1] and arr is 
   * <pre>
   * [10, 20, 30, 40]
   * </pre>
   * and
   * then after this method executes, arr is
   * <pre>
   * [40, 10, 40, 20].
   * </pre>  
   * If the swizzler length
   * does not match the array length, or if it contains any
   * number that is out of range as an index in arr, 
   * the method does nothing.  Note that this method 
   * modifies the given array and returns void.
   * @param arr
   *   the int array to be modified
   * @param swizzler
   *   array of indices indicating new positions of elements
   */
  public static void swizzle(int[] arr, int[] swizzler)
  {
	  if(arr.length == swizzler.length)
	  {
		  boolean check = true;
		  for (int index = 0; index < swizzler.length; ++index)
		  {
			  int value = swizzler[index];
			  if (value < arr.length && value >= 0) 
			  {
				  swizzler[index] = arr[value];
			  }
			  else
			  {
				  check = false;
				  break;
			  }
		  }
		  for (int i = 0; i < arr.length && check == true; ++i)
		  {
			  arr[i] = swizzler[i];
		  }
	  }
	  
  }
  
  /**
   * Creates a new array from the given one by adding up groups
   * of k adjacent entries.  The length of the returned array
   * is always <code>arr.length / k</code> (integer division), 
   * and its ith element is the sum
   * <p>
   * arr[ik] + arr[ik + 1] + arr[ik + 2] + ... + arr[ik + (k - 1)]
   * <p>
   * If the array length is not an exact multiple
   * of k, the excess elements are ignored.  For example, if
   * arr is [1, 2, 3, 4, 5, 6, 7] and k is 3, the 
   * result is [6, 15].
   * @param arr
   *   any int array
   * @param k
   *   number of adjacent elements in each group
   * @return
   *   new array obtained by adding up groups of adjacent elements
   */
  public static int[] condense(int[] arr, int k)
  {
	  int numParts = arr.length / k;
	  int[] condensedArray = new int[numParts];
	 
	  for (int part = 0; part < numParts; ++part)
	  {
		  for (int index = 0; index < k; ++index)
		  {
			  condensedArray[part] = condensedArray[part] + arr[index + part*k];
		  }
	  }
	  return condensedArray;
  }
  
  /**
   * Determines whether arr is a permutation.  We define
   * a permutation as an array in which each number 
   * 0 through n - 1 appears exactly once, where n is 
   * the length of the array.
   * @param arr
   *   an int array
   * @return
   *   true if the given array is a permutation, false otherwise
   */
  public static boolean isPermutation(int arr[])
  {
	  int n = arr.length;
	  int count = 0;
	  int[] compareArray = new int[n];
	  for (int k = 0; k <= n - 1; ++k)
	  {
		  compareArray[k] = k;
	  }
	  
	  for (int i = 0; i <= n - 1; ++i)
	  {
		  for (int j = 0; j <= n - 1; ++j)
		  {
			  if(compareArray[i] == arr[j])
			  {
				  count += 1;
				  break;
			  }
		  }
	  }
	  
	  if (count == n)
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }
  
  /**
   * Returns the cycle in arr beginning with the given starting index.
   * A <em>cycle</em> in an array is a sequence of indices 
   * i<sub>0</sub>, i<sub>1</sub>, i<sub>2</sub>, ...i<sub>k</sub>
   * for some k &gt;= 0, such that:
   * <p>
   * i<sub>1</sub> = arr[i<sub>0</sub>], i<sub>2</sub> = arr[i<sub>1</sub>], 
   * ..., and i<sub>0</sub> = arr[i<sub>k</sub>].  
   * <p>The sequence
   * of indices is returned as an int array with the given start index
   * at position 0.  
   * For example, given [2, 4, 0, 1, 3] and start = 3, the method
   * returns [3, 1, 4].  (Note that if arr[start] == start, then
   * the resulting cycle has length 1.)
   * Returns null if the given array is not
   * a permutation, or if the start index is out of bounds in arr.
   * @param arr
   *   an int array
   * @param start
   *   starting point for finding a cycle
   * @return
   *   array containing cycle indices, beginning with given start index
   *   
   */
  public static int[] findOneCycle(int[] arr, int start)
  {
	  ArrayList<Integer> indicesCycle = new ArrayList<Integer>(); //ArrayList to append elements.
	  boolean permutation = isPermutation(arr);
	  
	  if (permutation == true && (start < arr.length && start >= 0))
	  {
		  int i = start;
		  for (int count = 0; count < arr.length; ++count) //Adds indices to the ArrayList
		  {
			  indicesCycle.add(i);
			  i = arr[i];
			  if (i == start) // Breaks if the index matches the starting index
			  {
				  break;
			  }
			  if (i >= arr.length)
			  {
				  break;
			  }
		  }
		  
		  int[] result = new int[indicesCycle.size()]; //Converts to an array.
		  for (int j = 0; j < indicesCycle.size(); ++j)
		  {
			  result[j] = indicesCycle.get(j);
		  }
		  return result;
	  }
	  
	  return null;
	  
	  
  }
  
  /**
   * Returns a list of all cycles in the given array.
   * For example, given [2, 1, 3, 0, 5, 4], the resulting
   * list should contain [0, 2, 3], [1], and [4, 5].
   * The cycles in the resulting list should be disjoint; that is,
   * for example, 
   * the list should not contain [2, 3, 0] in addition to
   * [0, 2, 3], even though both arrays describe the same cycle.
   * The order of cycles in the list is not specified.
   * Returns an empty list if arr is not a permutation.
   * @param arr
   *   an int array
   * @return
   *   list of all cycles
   */
  public static ArrayList<int[]> findAllCycles(int[] arr)
  {
	  ArrayList<int[]> result = new ArrayList<int[]>();
	  boolean check = isPermutation(arr);
	  
	  if (check == false) // Checks is array is a permutation.
	  {
		  return result;
	  }
	  
	  boolean permutation = false;
	  
	  for (int index = 0; index < arr.length; ++index)
	  {
		  //Getting Pattern
		  int[] array = findOneCycle(arr, index); 
		  
		  // Catch any empty array.
		  if (array.length == 0) 
		  {
			  continue;
		  }
		  
		  //Iterate through every case
		  int n = array.length;
		  int count = 0;
		  for (int i = 0; i < result.size(); ++i) 
		  {
			  //Iterate through every element of the chosen array.
			  int[] compareArray = result.get(i);
			  for (int k = 0; k < compareArray.length; ++k) 
			  {
				  //Iterate through every element of result array.
				  for (int j = 0; j < array.length && j < compareArray.length; ++j) 
				  {
					  //If the numbers match, count 1 match and check next element.
					  if(compareArray[k] == array[j]) 
					  {
						  count += 1;
						  break;
					  }
				  }
			  }
			  
			  // If the count equals array length, permutation is true.
			  if (count == n)
			  {
				   permutation = true;
				   break;
			  }
			  else
			  {
				  permutation = false;
			  }
		  }
		  
		  // If the array is not a permutation of one in list, add it to the list.
		  if (permutation == false)
		  {
			  result.add(array);
		  }
	  }
	  
	  // Return the list of arrays.
	  return result;
  }
}
