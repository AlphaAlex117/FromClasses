package edu.iastate.cs228.hw3;

import java.util.AbstractSequentialList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Implementation of the list interface based on linked nodes
 * that store multiple items per node.  Rules for adding and removing
 * elements ensure that each node (except possibly the last one)
 * is at least half full.
 */
public class MultiList<E extends Comparable<? super E>> extends AbstractSequentialList<E>
{
  /**
   * Default number of elements that may be stored in each node.
   */
  private static final int DEFAULT_NODESIZE = 4;
  
  /**
   * Number of elements that can be stored in each node.
   */
  private final int nodeSize;
  
  /**
   * Dummy node for head.  It should be private but set to public here only  
   * for grading purpose.  In practice, you should always make the head of a 
   * linked list a private instance variable.  
   */
  public Node head;
  
  /**
   * Dummy node for tail.
   */
  private Node tail;
  
  /**
   * Number of elements in the list.
   */
  private int size;
  
  /**
   * Constructs an empty list with the default node size.
   */
  public MultiList()
  {
    this(DEFAULT_NODESIZE);
  }

  /**
   * Constructs an empty list with the given node size.
   * @param nodeSize number of elements that may be stored in each node, must be 
   *   an even number
   */
  public MultiList(int nodeSize)
  {
    if (nodeSize <= 0 || nodeSize % 2 != 0) throw new IllegalArgumentException();
    
    // dummy nodes
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.previous = head;
    this.nodeSize = nodeSize;
  }
  
  /**
   * Constructor for grading only.  Fully implemented. 
   * @param head
   * @param tail
   * @param nodeSize
   * @param size
   */
  public MultiList(Node head, Node tail, int nodeSize, int size)
  {
	  this.head = head; 
	  this.tail = tail; 
	  this.nodeSize = nodeSize; 
	  this.size = size; 
  }

  @Override
  public int size()
  {
    return size;
  }
  
  @Override
  public boolean add(E item)
  {
	  // If size is zero, then create a new node.
	  if (size == 0)
	  {
		  Node temp = new Node();
		  tail.previous.next = temp;
		  temp.next = tail;
		  temp.previous = tail.previous;
		  tail.previous = temp;
		  tail.previous.addItem(item);
		  size++;
    	
		  return true;
	  }
	  
	  // If the previous node isn't full, make a new one and add the object.
	  if (tail.previous.count < nodeSize)
	  {
		  tail.previous.addItem(item);
		  size++;
		  return true;
	  }
	  else if (tail.previous.count == nodeSize)
	  {
		  Node temp = new Node();
		  tail.previous.next = temp;
		  temp.next = tail;
		  temp.previous = tail.previous;
		  tail.previous = temp;
		  tail.previous.addItem(item);
		  size++;
    	
		  return true;
	  }
    
	  return false;
  }

  @Override
  public void add(int pos, E item)
  {
	  NodeInfo addNode = new NodeInfo(head.next, 0);
	  addNode.add(pos, item);
  }

  @Override
  public E remove(int pos)
  {
	  NodeInfo foundNodeInfo = new NodeInfo(head.next, 0).find(pos);
	  
	  E temp = foundNodeInfo.node.data[pos % nodeSize];
	  
	  if (foundNodeInfo.node == tail.previous && foundNodeInfo.node.count == 1)
	  {
		  foundNodeInfo.node.previous.next = foundNodeInfo.node.next;
		  foundNodeInfo.node.next.previous = foundNodeInfo.node.previous;
		  foundNodeInfo.node.next = null;
		  foundNodeInfo.node.previous = null;
		  size--;
		  return temp;
	  }
	  
	  if (foundNodeInfo.node == tail.previous || foundNodeInfo.node.count > nodeSize / 2)
	  {
		  foundNodeInfo.node.removeItem(pos % nodeSize);
		  size--;
		  return temp;
	  }
	  else
	  {
		  if (foundNodeInfo.node.next.count > nodeSize / 2)
		  {
			  E movingElement = foundNodeInfo.node.next.data[0];
			  foundNodeInfo.node.removeItem(pos % nodeSize);
			  foundNodeInfo.node.next.removeItem(0);
			  foundNodeInfo.node.addItem(pos % nodeSize, movingElement);
			  size--;
			  return temp;
		  }
		  else if (foundNodeInfo.node.next.count <= nodeSize / 2)
		  {
			  foundNodeInfo.node.removeItem(pos % nodeSize);
			  
			  for (int i = 0; i <= foundNodeInfo.node.next.count; i++)
			  {
				  E movingElement = foundNodeInfo.node.next.data[0];
				  foundNodeInfo.node.next.removeItem(0);
				  foundNodeInfo.node.addItem(pos % nodeSize + i, movingElement);
			  }
			  
			  foundNodeInfo.node.next.next.previous = foundNodeInfo.node;
			  foundNodeInfo.node.next = foundNodeInfo.node.next.next;
			  foundNodeInfo.node.next.next = null;
			  foundNodeInfo.node.next.previous = null;
			  size--;
			  return temp;
		  }
	  }
	  return null;
  }

  /**
   * Sort all elements in the Multi list in NON-DECREASING order. You may do the following. 
   * Traverse the list and copy its elements into an array, deleting every visited node along 
   * the way.  Then, sort the array by calling the insertionSort() method.  (Note that sorting 
   * efficiency is not a concern for this project.)  Finally, copy all elements from the array 
   * back to the Multi list, creating new nodes for storage. After sorting, all nodes but 
   * (possibly) the last one must be full of elements.  
   *  
   * Comparator<E> must have been implemented for calling insertionSort().    
   */
  public void sort()
  {
	  doSortedList('I');
  }
  
  /**
   * Sort all elements in the Multi list in NON-INCREASING order. Call the bubbleSort()
   * method.  After sorting, all but (possibly) the last nodes must be filled with elements.  
   *  
   * Comparable<? super E> must be implemented for calling bubbleSort(). 
   */
  public void sortReverse() 
  {
	  doSortedList('B');
  }
  
  @Override
  public Iterator<E> iterator()
  {
    return new MultiListIterator();
  }

  @Override
  public ListIterator<E> listIterator()
  {
    return new MultiListIterator();
  }

  @Override
  public ListIterator<E> listIterator(int index)
  {
	  if (index > size || index < 0)
	  {
		  throw new IndexOutOfBoundsException();
	  }
	  return new MultiListIterator(index);
  }
  
  /**
   * Returns a string representation of this list showing
   * the internal structure of the nodes.
   */
  public String toStringInternal()
  {
    return toStringInternal(null);
  }

  /**
   * Returns a string representation of this list showing the internal
   * structure of the nodes and the position of the iterator.
   *
   * @param iter
   *            an iterator for this list
   */
  public String toStringInternal(ListIterator<E> iter) 
  {
      int count = 0;
      int position = -1;
      if (iter != null) {
          position = iter.nextIndex();
      }

      StringBuilder sb = new StringBuilder();
      sb.append('[');
      Node current = head.next;
      while (current != tail) {
          sb.append('(');
          E data = current.data[0];
          if (data == null) {
              sb.append("-");
          } else {
              if (position == count) {
                  sb.append("| ");
                  position = -1;
              }
              sb.append(data.toString());
              ++count;
          }

          for (int i = 1; i < nodeSize; ++i) {
             sb.append(", ");
              data = current.data[i];
              if (data == null) {
                  sb.append("-");
              } else {
                  if (position == count) {
                      sb.append("| ");
                      position = -1;
                  }
                  sb.append(data.toString());
                  ++count;

                  // iterator at end
                  if (position == size && count == size) {
                      sb.append(" |");
                      position = -1;
                  }
             }
          }
          sb.append(')');
          current = current.next;
          if (current != tail)
              sb.append(", ");
      }
      sb.append("]");
      return sb.toString();
  }


  /**
   * Node type for this list.  Each node holds a maximum
   * of nodeSize elements in an array.  Empty slots
   * are null.
   */
  private class Node
  {
    /**
     * Array of actual data elements.
     */
    // Unchecked warning unavoidable.
    public E[] data = (E[]) new Comparable[nodeSize];
    
    /**
     * Link to next node.
     */
    public Node next;
    
    /**
     * Link to previous node;
     */
    public Node previous;
    
    /**
     * Index of the next available offset in this node, also 
     * equal to the number of elements in this node.
     */
    public int count;

    /**
     * Adds an item to this node at the first available offset.
     * Precondition: count < nodeSize
     * @param item element to be added
     */
    void addItem(E item)
    {
      if (count >= nodeSize)
      {
        return;
      }
      data[count++] = item;
      //useful for debugging
      //      System.out.println("Added " + item.toString() + " at index " + count + " to node "  + Arrays.toString(data));
    }
  
    /**
     * Adds an item to this node at the indicated offset, shifting
     * elements to the right as necessary.
     * 
     * Precondition: count < nodeSize
     * @param offset array index at which to put the new element
     * @param item element to be added
     */
    void addItem(int offset, E item)
    {
      if (count >= nodeSize)
      {
    	  return;
      }
      for (int i = count - 1; i >= offset; --i)
      {
        data[i + 1] = data[i];
      }
      ++count;
      data[offset] = item;
      //useful for debugging 
      //System.out.println("Added " + item.toString() + " at index " + offset + " to node: "  + Arrays.toString(data));
    }

    /**
     * Deletes an element from this node at the indicated offset, 
     * shifting elements left as necessary.
     * Precondition: 0 <= offset < count
     * @param offset
     */
    void removeItem(int offset)
    {
      E item = data[offset];
      for (int i = offset + 1; i < nodeSize; ++i)
      {
        data[i - 1] = data[i];
      }
      data[count - 1] = null;
      --count;
    }    
  }
 
  private class MultiListIterator implements ListIterator<E>
  {
	 /**
	  * Store the directions for remove and set methods.
	  */
	 private static final int BEHIND = -1;
	 private static final int NONE = 0;
	 private static final int AHEAD = 1;
	 
	 /**
	  * Stores the default start of an iterator.
	  */
	 private static final int DEFAULT_START = 0;
	  
	 /**
	  * Stores the position of the virtual cursor.
	  */
	 private Node cursor;
	 
	 /**
	  * Stores the node cursor was before a call to next or previous.
	  */
	 private Node pending;
	 
	 /**
	  * Stores the index of the iterator.
	  */
	 private int index;
	 
	 /**
	  * Stores the offset of the iterator.
	  */
	 private int off;
	 
	 /**
	  * Stores the direction of the iterator.
	  */
	 private int direction;
	  
    /**
     * Default constructor 
     */
    public MultiListIterator()
    {
    	this(DEFAULT_START);
    }

    /**
     * Constructor finds node at a given position.
     * @param pos
     */
    public MultiListIterator(int pos)
    {	
    	cursor = head.next;
    	off = 0;
    	direction = NONE;
    	NodeInfo newNode = new NodeInfo(cursor, off).find(pos);
    	index = pos + newNode.offset;
    	cursor = newNode.node;
    }

    @Override
    public boolean hasNext()
    {
    	if (nextIndex() > size)
    	{
    		return false;
    	}
    	
    	NodeInfo nextNodeInfo = new NodeInfo(head.next, off).find(nextIndex()-off);
    	
    	if (nextNodeInfo.node.count == 0)
    	{
    		return false;
    	}
    	
    	if (nextNodeInfo.node.data[(nextIndex()+nextNodeInfo.offset)% nodeSize] == null)
    	{
    		return false;
    	}
    	
    	return true;
    }

    @Override
    public E next()
    {
    	if (!hasNext())
    	{
    		throw new NoSuchElementException();
    	}
    	else
    	{
    		// Grabs the location of the element before updating.
    		int pendingIndex = index;
    		int pendingOffset = off;
    		pending = cursor;
    		
    		NodeInfo nextNodeInfo = new NodeInfo(head.next, off).find((index + 1)-off);
    		cursor = nextNodeInfo.node;
    		index += 1;
    		off = nextNodeInfo.offset;
    		
    		direction = BEHIND;
    		
    		return pending.data[(pendingIndex-pendingOffset) % nodeSize];
    	}
    }

    @Override
    public void remove()
    {
    	
    	if(direction == NONE)
    	{
    		throw new IllegalStateException();
    	}
    	else if (direction == BEHIND)
    	{
    		NodeInfo foundNode = new NodeInfo(head.next, off).find(previousIndex()-off);
    		foundNode.node.removeItem(previousIndex() % nodeSize);
    	}
    	else if (direction ==  AHEAD)
    	{
    		NodeInfo foundNode = new NodeInfo(head.next, off).find(nextIndex()-off);
    		foundNode.node.removeItem(nextIndex() % nodeSize);
    	}
    	index--;
    	size--;
    	direction = NONE;
    }

	@Override
	public boolean hasPrevious() 
	{	
		// Check that previous index isn't less than 0.
		if (previousIndex() - off < 0)
		{
			return false;
		}
		
		NodeInfo previousNodeInfo = new NodeInfo(head.next, off).find(previousIndex()-off);
		
		if (previousNodeInfo.node.count == 0)
		{
			return false;
		}
		
		if (previousNodeInfo.node.data[(previousIndex()+previousNodeInfo.offset) % nodeSize] == null) 
		{
			return false;
		}
			
		return true;
	}

	@Override
	public E previous() 
	{
		if (!hasPrevious())
		{
			throw new NoSuchElementException();
		}
		else
		{
			// Grabs the location of the element before updating.
			int pendingIndex = index-1;
			int pendingOffset = off;
			pending = cursor;
			
			NodeInfo previousNodeInfo = new NodeInfo(head.next, off).find((index-1)-off);
			cursor = previousNodeInfo.node;
			index--;
			off = previousNodeInfo.offset;
			
			direction = AHEAD;
			
			return pending.data[(pendingIndex-pendingOffset) % nodeSize];
		}
	}

	@Override
	public int nextIndex() 
	{
		return index;
	}

	@Override
	public int previousIndex() 
	{
		return index-1;
	}

	@Override
	public void set(E e) 
	{
		if (direction == NONE)
		{
			throw new IllegalStateException();
		}
		else if (direction == AHEAD)
		{
			NodeInfo nextNodeInfo = new NodeInfo(head.next, off).find(nextIndex()-off);
			nextNodeInfo.node.data[nextIndex() % nodeSize] = e;
		}
		else if (direction == BEHIND)
		{
			NodeInfo previousNodeInfo = new NodeInfo(head.next, off).find(previousIndex()-off);
			previousNodeInfo.node.data[previousIndex() % nodeSize] = e;
		}
	}

	@Override
	public void add(E e) {
		
		NodeInfo addNode = new NodeInfo(head.next, off);
		addNode.add(index-off, e);
		index++;
		direction = NONE;
	}
  }
  

  /**
   * Sort an array arr[] using the insertion sort algorithm in the NON-DECREASING order. 
   * @param arr   array storing elements from the list 
   * @param comp  comparator used in sorting 
   */
  private void insertionSort(E[] arr, Comparator<? super E> comp)
  {
	  int n = arr.length;
	  for (int i = 1; i <= n-1; i++)
	  {
		  E temp = arr[i];
		  int j = i - 1;
		  while (j > -1 && comp.compare(arr[j],temp) >= 0)
		  {
			  arr[j+1] = arr[j];
			  --j;
		  }
		  arr[j+1] = temp;
	  }
  }
  
  /**
   * Sort arr[] using the bubble sort algorithm in the NON-INCREASING order. For a 
   * description of bubble sort please refer to Section 6.1 in the project description. 
   * You must use the compareTo() method from an implementation of the Comparable 
   * interface by the class E or ? super E. 
   * @param arr  array holding elements from the list
   */
  private void bubbleSort(E[] arr)
  {
	  int n = arr.length;
	  boolean hasSwapped = true;
	  while (hasSwapped)
	  {
		  hasSwapped = false;
		  for (int i = 1; i <= n-1; i++)
		  {
			  if (arr[i-1].compareTo(arr[i]) < 0)
			  {
				  E temp = arr[i-1];
				  arr[i-1] = arr[i];
				  arr[i] = temp;
				  
				  hasSwapped = true;
			  }
		  }
	  }
  }
  
  /**
   * Helper method to put the repeated code from the sort() and sortReverse() methods.
   * @param type
   */
  private void doSortedList(char type)
  {
	  E[] tempArray = (E[]) new Comparable[size];
	  Node current = head.next;
	  int indexDifference = 0;
	  
	  // Removes every element and adds it to the array.
	  for (int i = 0; i + indexDifference < size; i++)
	  {
		  if (current.data[i % nodeSize] != null)
		  {
			  tempArray[i+indexDifference] = current.data[i % nodeSize];
		  }
		  else if (current.data[i % nodeSize] == null)
		  {
			  i += nodeSize-current.count;
			  indexDifference -= nodeSize-current.count;
			  current = current.next;
			  
			  current.previous.next = null;
			  current.previous.previous = null;
			  head.next = current;
			  current.previous = head;
			  
			  tempArray[i+indexDifference] = current.data[i % nodeSize];
		  }
	  }
	  
	  // Unlink the last Node.
	  head.next.next = null;
	  head.next.previous = null;
	  head.next = tail;
	  tail.previous = head;
	  size = 0;
	  
	  // Sort the array.
	  if (type == 'I')
	  {
		  insertionSort(tempArray, new GenericComparator());
	  }
	  else if (type == 'B')
	  {
		  bubbleSort(tempArray);
	  }
	  
	  //Add every component in the array to the list.
	  for (int i = 0; i < tempArray.length; i++)
	  {
		  add(tempArray[i]);
	  }
  }
  
  
  	/**
	 * Class that finds has info on the node and the offset counted up to that node.
	 * @author Alexander Lafontaine
	 *
	 */
	private class NodeInfo
	{
		Node node;
		int offset;
		
		NodeInfo(Node n, int o)
		{
			node = n;
			offset = o;
		}
		
		NodeInfo find(int pos)
		{
			int newOffset = 0;
			Node newNode = node;
			int tempPos = -1;
			
			if (pos == size)
			{
				while (newNode.count + tempPos < pos-1)
		    	{
		    		newOffset += (nodeSize - newNode.count);
		    		tempPos += newNode.count;
		    		newNode = newNode.next;
		    	}
				
				return new NodeInfo(newNode, newOffset);
			}
			
			while (newNode.count + tempPos < pos)
	    	{
	    		newOffset += (nodeSize - newNode.count);
	    		tempPos += newNode.count;
	    		newNode = newNode.next;
	    	}
			
			return new NodeInfo(newNode, newOffset);
		}
		
		void add(int pos, E item)
		{
			if (item == null)
			{
				throw new NullPointerException();
			}
			
			// If size is zero, create a new node.
		  	if (size == 0)
		  	{
		  		Node temp = new Node();
			  	tail.previous.next = temp;
			  	temp.next = tail;
			  	temp.previous = tail.previous;
			  	tail.previous = temp;
			  	tail.previous.addItem(item);
			  	size++;
			  	return;
		  	}
			  
			/*
			 * If size is not zero, then search for the node at the current input.
			 * If that node has space, then add the component with add(pos,item).
			 * Otherwise, create a new node, split the array in half, the last half is placed
			 * 	on the new node and then put the item and the indicated place.
			 */
		  	NodeInfo foundNodeInfo = new NodeInfo(head.next, 0).find(pos);
			  
			if (foundNodeInfo.node.count < nodeSize)
			{	
				if (foundNodeInfo.node.data[pos % nodeSize] == null)
				{
					foundNodeInfo.node.addItem(foundNodeInfo.node.count, item);
				}
				else
				{
					foundNodeInfo.node.addItem(pos % nodeSize, item);
				}
		  		size++;
		 		return;
			}
			else if (foundNodeInfo.node.count == nodeSize)
			{
			  	Node temp = new Node();
			  	foundNodeInfo.node.next.previous = temp;
			  	temp.next = foundNodeInfo.node.next;
			  	temp.previous = foundNodeInfo.node;
			  	foundNodeInfo.node.next = temp;
				  
				  
			  	int tempIndex = 0;
			  	for (int i = nodeSize / 2; i < nodeSize ; i++)
			  	{
			  		temp.data[tempIndex] = foundNodeInfo.node.data[i];
			  		foundNodeInfo.node.data[i] = null;
			  		foundNodeInfo.node.count--;
			  		temp.count++;
			  		tempIndex++;
			  	}
				  
			  	if (foundNodeInfo.node.data[pos % nodeSize] == null)
				{
					foundNodeInfo.node.addItem(foundNodeInfo.node.count, item);
				}
				else
				{
					foundNodeInfo.node.addItem(pos % nodeSize, item);
				}
		  		size++;
		 		return;
			}
	  	}
	}
	
	/**
	 * Comparator for any type E that implements a comparator.
	 * 
	 * @author Alexander Lafontaine
	 *
	 * @param <E>
	 */
	private class GenericComparator<E extends Comparable<E>> implements Comparator<E>
	{
		public int compare(E x, E y)
		{
			return x.compareTo(y);
		}
	}
}