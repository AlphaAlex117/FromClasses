package hw3.tests;
import org.junit.Test;

import edu.iastate.cs228.hw3.MultiList;

import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ListIterator;

public class MultilistTest {

	String s;
	String s2;
	String s3;
	String setter;
	
	@Before
	public void MultiTestSetUp()
	{
		s = "BRUH";
		s2 = "bruhhh";
		s3 = "MoMeNtO";
		setter = "Lali";
	}
	
	@Test
	public void MultiListAddTest()
	{
		MultiList m = new MultiList(4);
		m.add(s);
	}
	
	@Test
	public void MultiListAddTest2()
	{
		MultiList m = new MultiList(2);
		m.add(s);
		m.add(s2);
		m.add(s3);
		//System.out.println(m.toStringInternal());
		//System.out.println(m.size());
	}
	
	@Test
	public void MultiListIteratorConstructorTest()
	{
		MultiList m = new MultiList(2);
		m.add(s);
		m.add(s2);
		m.add(s3);
		
		//System.out.println(m.toStringInternal(m.listIterator()));
	}
	
	@Test
	public void MultiListIteratorConstructorTest2()
	{
		MultiList m = new MultiList(2);
		m.add(s);
		m.add(s2);
		m.add(s3);
		m.add(s);
		m.add(s);
		
		//System.out.println(m.toStringInternal(m.listIterator(2)));
	}
	
	@Test
	public void MultiListIteratorHasNext()
	{
		MultiList m = new MultiList(4);
		m.add(s);
		m.add(s2);
		m.add(s);
		m.add(s3);
		m.add(s2);
		
		ListIterator iter = m.listIterator(4);
		
		//System.out.println(m.toStringInternal(iter));
		//System.out.println(iter.hasNext());
	}
	
	@Test
	public void MultiListIteratorHasNext2()
	{
		MultiList m = new MultiList(4);
		m.add(s);
		m.add(s2);
		m.add(s);
		m.add(s3);
		m.add(s2);
		
		ListIterator iter = m.listIterator(5);
		//System.out.println(m.toStringInternal(iter));
		//System.out.println(iter.hasNext());
	}
	
	@Test
	public void MultiListIteratorNext()
	{
		MultiList m = new MultiList(2);
		m.add(s);
		m.add(s2);
		m.add(s3);
		m.add(s2);
		m.add(s);
		
		ListIterator iter = m.listIterator(3);
		//System.out.println(m.toStringInternal(iter));
		//System.out.println(iter.next());
		//System.out.println(m.toStringInternal(iter));
	}
	
	@Test
	public void MultiListIteratorHasPrevious()
	{	
		MultiList m = new MultiList(4);
		m.add(s);
		m.add(s2);
		m.add(s);
		m.add(s3);
		m.add(s2);
		
		ListIterator iter = m.listIterator(4);
		//System.out.println(m.toStringInternal(iter));
		//System.out.println(iter.hasPrevious());
	}
	
	@Test
	public void MultiListIteratorHasPrevious2()
	{
		MultiList m = new MultiList(4);
		m.add(s);
		m.add(s2);
		m.add(s);
		m.add(s3);
		m.add(s2);
		
		ListIterator iter = m.listIterator();
		//System.out.println(m.toStringInternal(iter));
		//System.out.println(iter.hasPrevious());
	}
	
	@Test
	public void MultiListIteratorPrevious()
	{
		MultiList m = new MultiList(2);
		m.add(s);
		m.add(s2);
		m.add(s3);
		m.add(s2);
		m.add(s);
		
		ListIterator iter = m.listIterator(3);
		//System.out.println(m.toStringInternal(iter));
		//System.out.println(iter.previous());
		//System.out.println(m.toStringInternal(iter));
	}
	
	@Test
	public void MultiListIteratorSet()
	{
		MultiList m = new MultiList(2);
		m.add(s);
		m.add(s2);
		m.add(s3);
		m.add(s2);
		m.add(s);
		
		ListIterator iter = m.listIterator(2);
		//System.out.println(m.toStringInternal(iter));
		iter.previous();
		//System.out.println(m.toStringInternal(iter));
		iter.set(setter);
		//System.out.println(m.toStringInternal(iter));
		iter.next();
		//System.out.println(m.toStringInternal(iter));
		iter.next();
		//System.out.println(m.toStringInternal(iter));
		iter.set(setter);
		//System.out.println(m.toStringInternal(iter));
		
	}
	
	@Test
	public void MultiListIndexedAdd()
	{
		MultiList m = new MultiList(4);
		m.add(s);
		m.add(s2);
		
		//System.out.println(m.toStringInternal());
		m.add(1, s3);
		//System.out.println(m.toStringInternal());
		m.add(1,setter);
		//System.out.println(m.toStringInternal());
		//System.out.println();
	}
	
	@Test
	public void MultiListIndexedAdd2()
	{
		MultiList m = new MultiList(2);
		m.add(s);
		
		//System.out.println(m.toStringInternal());
		m.add(s2);
		//System.out.println(m.toStringInternal());
		m.add(1, setter);
		//System.out.println(m.toStringInternal());
		//System.out.println();
	}
	
	@Test
	public void MultiListIndexedAdd3()
	{
		MultiList m = new MultiList(4);
		m.add(s);
		m.add(s2);
		m.add(s3);
		m.add(s2);
		m.add(s);
		
		//System.out.println(m.toStringInternal());
		m.add(2, setter);
		//System.out.println(m.toStringInternal());
		m.add(setter);
		//System.out.println(m.toStringInternal());
		//System.out.println();
	}
	
	@Test
	public void MultiListRemove()
	{
		MultiList m = new MultiList(4);
		m.add(s);
		m.add(s2);
		m.add(s3);
		m.add(s2);
		m.add(s);
		
		//System.out.println(m.toStringInternal());
		m.remove(4);
		//System.out.println(m.toStringInternal());
	}
	
	@Test
	public void MultiListRemove2()
	{
		MultiList m = new MultiList(4);
		m.add(s);
		m.add(s2);
		m.add(s3);
		m.add(s2);
		m.add(s);
		m.add(s);
		m.add(s2);
		
		//System.out.println(m.toStringInternal());
		m.remove(5);
		//System.out.println(m.toStringInternal());
		m.remove(5);
		//System.out.println(m.toStringInternal());
		m.remove(2);
		//System.out.println(m.toStringInternal());
	}
	
	@Test
	public void MultiListRemove3()
	{
		MultiList m = new MultiList(4);
		m.add(s);
		m.add(s2);
		m.add(s3);
		m.add(s2);
		m.add(s);
		m.add(s);
		m.add(s2);
		
		//System.out.println(m.toStringInternal());
		m.remove(1);
		//System.out.println(m.toStringInternal());
		m.remove(1);
		//System.out.println(m.toStringInternal());
		m.remove(1);
		//System.out.println(m.toStringInternal());
	}
	
	@Test
	public void MultiListRemove4()
	{
		MultiList m = new MultiList(4);
		m.add(s);
		m.add(s2);
		m.add(s3);
		m.add(s2);
		m.add(s);
		m.add(s);
		m.add(s2);
		
		//System.out.println(m.toStringInternal());
		m.remove(1);
		//System.out.println(m.toStringInternal());
		m.remove(1);
		//System.out.println(m.toStringInternal());
		m.remove(1);
		//System.out.println(m.toStringInternal());
		m.remove(1);
		//System.out.println(m.toStringInternal());
	}
	
	@Test
	public void MultiListIteratorAdd()
	{
		MultiList m = new MultiList(4);
		m.add(s);
		m.add(s2);
		m.add(s3);
		m.add(s2);
		m.add(s);
		
		ListIterator iter = m.listIterator(3);
		//System.out.println(m.toStringInternal(iter));
		iter.add(setter);
		//System.out.println(m.toStringInternal(iter));
	}
	
	@Test
	public void MultiListIteratorRemove()
	{
		MultiList m = new MultiList(4);
		m.add(s);
		m.add(s2);
		m.add(s3);
		m.add(s2);
		m.add(s);
		
		ListIterator iter = m.listIterator(2);
		//System.out.println(m.toStringInternal(iter));
		iter.next();
		//System.out.println(m.toStringInternal(iter));
		iter.remove();
		//System.out.println(m.toStringInternal(iter));
		iter.previous();
		//System.out.println(m.toStringInternal(iter));
		iter.previous();
		//System.out.println(m.toStringInternal(iter));
		iter.remove();
		//System.out.println(m.toStringInternal(iter));
	}
	
	@Test
	public void MultiListIteratorAddThenRemove()
	{
		MultiList m = new MultiList(4);
		m.add(s);
		m.add(s2);
		m.add(s3);
		m.add(s2);
		m.add(s);
		
		ListIterator iter = m.listIterator(3);
		//System.out.println(m.toStringInternal(iter));
		iter.add(setter);
		//System.out.println(m.toStringInternal(iter));
		iter.previous();
		//System.out.println(m.toStringInternal(iter));
		iter.remove();
		//System.out.println(m.toStringInternal(iter));
	}

	@Test
	public void MultiListSort()
	{
		MultiList m = new MultiList(4);
		m.add(s);
		m.add(s2);
		m.add(s3);
		m.add(s2);
		m.add(s);
		m.add(2, setter);
		m.add(setter);
		
		//System.out.println(m.toStringInternal());
		m.sort();
		//System.out.println(m.toStringInternal());
		
	}
	
	@Test
	public void MultiListSort2()
	{
		MultiList m = new MultiList(4);
		m.add('C');
		m.add('M');
		m.add('B');
		m.add('F');
		m.add('U');
		m.add(2, 'P');
		m.add('P');
		
		System.out.println(m.toStringInternal());
		m.sort();
		System.out.println(m.toStringInternal());
		System.out.println();
		
	}
	
	@Test
	public void MultiListReverseSort()
	{
		MultiList m = new MultiList(4);
		m.add('C');
		m.add('M');
		m.add('B');
		m.add('F');
		m.add('U');
		m.add(2, 'P');
		m.add('P');
		
		System.out.println(m.toStringInternal());
		m.sortReverse();
		System.out.println(m.toStringInternal());
		System.out.println();
	}
}
