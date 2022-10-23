package hw4;

import org.junit.Test;

import edu.iastate.cs228.hw4.SplayTree;

import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SplayTreeTest {

	Character b;
	Character g;
	Character a;
	Character e;
	
	@Before
	public void SetUp()
	{
		a = 'A';
		b = 'B';
		g = 'G';
		e = 'E';
	}
	
	@Test
	public void findElementTest()
	{
		SplayTree<Character> tree = new SplayTree<Character>(e);
		tree.addBST(b);
		tree.addBST('W');
		tree.addBST(a);
		tree.addBST('C');
		tree.addBST('D');
		tree.addBST('G');
		tree.addBST('H');
		System.out.println(tree.toString());
		Character cha = tree.findElement('I');
		System.out.println(cha);
		System.out.println(tree.toString());
		System.out.println(tree.contains('I'));
		System.out.println(tree.toString());
	}
	
	@Test
	public void toStringTest()
	{
		SplayTree<Character> tree = new SplayTree<Character>(e);
		tree.addBST(b);
		tree.addBST('W');
		tree.addBST(a);
		tree.addBST('C');
		tree.addBST('D');
		tree.addBST('G');
		tree.addBST('H');
		System.out.println(tree.toString());
	}
	
	@Test
	public void toStringTestNum()
	{
		SplayTree<Integer> tree = new SplayTree<Integer>(50);
		tree.addBST(30);
		tree.addBST(55);
		tree.addBST(25);
		tree.addBST(35);
		tree.addBST(10);
		tree.addBST(31);
		tree.addBST(37);
		tree.addBST(20);
		tree.addBST(53);
		tree.addBST(60);
		tree.addBST(62);
		System.out.println(tree.toString());
	}
	
	@Test
	public void cloneTreeRecTest()
	{
		SplayTree<Integer> tree = new SplayTree<Integer>(50);
		tree.addBST(30);
		tree.addBST(55);
		tree.addBST(25);
		tree.addBST(35);
		tree.addBST(10);
		tree.addBST(31);
		tree.addBST(37);
		tree.addBST(20);
		tree.addBST(53);
		tree.addBST(60);
		tree.addBST(62);
		System.out.println(tree.toString());
		
		System.out.println();
		
		SplayTree<Integer> clone = new SplayTree<Integer>(tree);
		System.out.println(clone.toString());
	}
	
	@Test
	public void removeTest()
	{
		SplayTree<Integer> tree = new SplayTree<Integer>(50);
		tree.addBST(30);
		tree.addBST(55);
		tree.addBST(25);
		tree.addBST(35);
		tree.addBST(10);
		tree.addBST(31);
		tree.addBST(37);
		tree.addBST(20);
		tree.addBST(53);
		tree.addBST(60);
		tree.addBST(62);
		System.out.println(tree.toString());
		System.out.println();
		tree.remove(30);
		System.out.println(tree.toString());
	}
	
	@Test
	public void removeTest2()
	{
		SplayTree<Integer> tree = new SplayTree<Integer>(50);
		tree.addBST(30);
		tree.addBST(55);
		tree.addBST(25);
		tree.addBST(35);
		tree.addBST(10);
		tree.addBST(31);
		tree.addBST(37);
		tree.addBST(20);
		tree.addBST(53);
		tree.addBST(60);
		tree.addBST(62);
		System.out.println(tree.toString());
		System.out.println();
		tree.remove(25);
		System.out.println(tree.toString());
	}
	
	@Test
	public void ZigSplayTest()
	{
		SplayTree<Character> tree = new SplayTree<Character>('H');
		tree.addBST('F');
		tree.addBST('J');
		tree.addBST('D');
		tree.addBST('G');
		System.out.println(tree.toString());
		tree.splay('F');
		System.out.println(tree.toString());
	}
	
	@Test
	public void ZigZigSplayTest()
	{
		SplayTree<Character> tree = new SplayTree<Character>('H');
		tree.addBST('F');
		tree.addBST('J');
		tree.addBST('D');
		tree.addBST('G');
		tree.addBST('A');
		tree.addBST('E');
		System.out.println(tree.toString());
		tree.splay('D');
		System.out.println(tree.toString());
	}
	
	@Test
	public void ZigZagSplayTest()
	{
		SplayTree<Character> tree = new SplayTree<Character>('H');
		tree.addBST('D');
		tree.addBST('F');
		tree.addBST('J');
		tree.addBST('G');
		tree.addBST('A');
		tree.addBST('E');
		System.out.println(tree.toString());
		tree.splay('F');
		System.out.println(tree.toString());
	}
	
	@Test
	public void addTest()
	{
		SplayTree<Character> tree = new SplayTree<Character>('H');
		System.out.println(tree.toString());
		tree.add('D');
		System.out.println(tree.toString());
		tree.add('F');
		System.out.println(tree.toString());
		tree.add('J');
		System.out.println(tree.toString());
		tree.add('G');
		System.out.println(tree.toString());
		tree.add('A');
		System.out.println(tree.toString());
		tree.add('E');
		System.out.println(tree.toString());
	}
	
	@Test
	public void addTest2()
	{
		SplayTree<Character> tree = new SplayTree<Character>('H');
		tree.add('H');
		System.out.println(tree.toString());
	}
	
	@After
	public void MarkEnd()
	{
		System.out.println();
		System.out.println("__________End Line__________");
		System.out.println();
	}
}
