package tests;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import listClasses.SortedLinkedList;
import listClasses.BasicLinkedList;
import java.util.*;

/**
 * 
 * You need student tests if you are looking for help during office hours about
 * bugs in your code.
 * 
 * @author UMCP CS Department
 *
 */
public class StudentTests {

	@Test
	public void basicAddToEnd() {
		BasicLinkedList<String> myList = new BasicLinkedList<String>();
		myList.addToEnd("a");
		myList.addToEnd("b");
		myList.addToEnd("c");
		
		String expected = "a, b, c";
		
		//System.out.println(myList.toString());
		assertEquals(expected, myList.toString());
	}
	
	@Test
	public void basicAddToFront() {
		BasicLinkedList<String> myList = new BasicLinkedList<String>();
		myList.addToFront("a");
		myList.addToFront("b");
		myList.addToFront("c");
		
		String expected = "c, b, a";
		
		//System.out.println(myList.toString());
		assertEquals(expected, myList.toString());
	}
	
	@Test
	public void basicGetFirst() {
		BasicLinkedList<String> myList = new BasicLinkedList<String>();
		myList.addToEnd("a");
		myList.addToEnd("b");
		myList.addToEnd("c");
		
		String expected = "a";
		
		assertEquals(expected, myList.getFirst());
	}
	
	@Test
	public void basicGetFirstEmpty() {
		BasicLinkedList<String> myList = new BasicLinkedList<String>();
		assertEquals(null, myList.getFirst());
	}
	
	@Test
	public void basicGetLast() {
		BasicLinkedList<String> myList = new BasicLinkedList<String>();
		myList.addToEnd("a");
		myList.addToEnd("b");
		myList.addToEnd("c");
		
		
		String expected = "c";
		
		assertEquals(expected, myList.getLast());
	}
	
	@Test
	public void basicGetSizeOne() {
		BasicLinkedList<String> myList = new BasicLinkedList<String>();
		myList.addToEnd("a").addToEnd("b").addToEnd("c").addToEnd("d");
		myList.retrieveFirstElement();
		myList.retrieveLastElement();
		
		assertEquals(2, myList.getSize());
	}
	
	@Test
	public void basicGetSizeTwo() {
		BasicLinkedList<String> myList = new BasicLinkedList<String>();
		myList.addToEnd("a").addToEnd("a").addToEnd("c").addToEnd("a");
		myList.remove("a", String.CASE_INSENSITIVE_ORDER);
		
		assertEquals(1, myList.getSize());
	}
	
	@Test
	public void basicRetrieveFirstElement() {
		BasicLinkedList<String> myList = new BasicLinkedList<String>();
		myList.addToEnd("a");
		myList.addToEnd("b");
		myList.addToEnd("c");
		
		String expectedList = "b, c";
		String expectedReturn = "a";
		
		assertEquals(expectedReturn, myList.retrieveFirstElement());
		assertEquals(expectedList, myList.toString());
	}
	
	@Test
	public void basicRetrieveFirstElementEmpty() {
		BasicLinkedList<String> myList = new BasicLinkedList<String>();
		myList.addToEnd("a");
		myList.retrieveFirstElement();
		assertEquals("", myList.toString());
	}
	
	@Test
	public void basicRetrieveLastElementEmpty() {
		BasicLinkedList<String> myList = new BasicLinkedList<String>();
		myList.addToEnd("a");
		myList.retrieveLastElement();
		assertEquals("", myList.toString());
	}
	
	@Test
	public void basicRetrieveLastElement() {
		BasicLinkedList<String> myList = new BasicLinkedList<String>();
		myList.addToEnd("a");
		myList.addToEnd("b");
		myList.addToEnd("c");
		
		String expectedList = "a, b";
		String expectedReturn = "c";
		
		assertEquals(expectedReturn, myList.retrieveLastElement());
		assertEquals(expectedList, myList.toString());
	}
	
	@Test
	public void basicRemoveOne() {
		BasicLinkedList<String> myList = new BasicLinkedList<String>();
		myList.addToEnd("a").addToEnd("a").addToEnd("b").addToEnd("a");
		
		String expected = "b";
	
		myList.remove("a", String.CASE_INSENSITIVE_ORDER);
		//System.out.println(myList.toString());
		assertEquals(expected, myList.toString());
	}
	
	@Test
	public void basicRemoveTwo() {
		BasicLinkedList<String> myList = new BasicLinkedList<String>();
		myList.addToEnd("a").addToEnd("a").addToEnd("a");
		myList.remove("a", String.CASE_INSENSITIVE_ORDER);
		
		//System.out.println(myList.toString());
		assertEquals("", myList.toString());
	}
	
	@Test
	public void basicIterator() {
		BasicLinkedList<String> myList = new BasicLinkedList<String>();
		myList.addToEnd("c").addToEnd("c").addToEnd("b").addToEnd("a");
		Iterator<String> it = myList.iterator();
		
		String expectedOne = "ccba";
		String expectedTwo = "ccba";
		
		String answerOne = "";
		String answerTwo = "";
		while (it.hasNext()) {
			answerOne += it.next();
		}
		for (String str : myList)
			answerTwo += str;
		
		assertEquals(expectedOne, answerOne);
		assertEquals(expectedTwo, answerTwo);
	}
	
	@Test
	public void basicGetReverseArrayList() {
		BasicLinkedList<String> myList = new BasicLinkedList<String>();
		myList.addToEnd("a").addToEnd("b").addToEnd("c");
		
		String expected = "cba";
		
		ArrayList<String> reverseList = myList.getReverseArrayList();
		String answer = "";
		for (String str : reverseList)
			answer += str;
		
		assertEquals(expected, answer);
	}
	
	@Test
	public void basicGetReverseList() {
		BasicLinkedList<String> myList = new BasicLinkedList<String>();
		myList.addToEnd("a").addToEnd("b").addToEnd("c");
		
		String expected = "c, b, a";
		
		assertEquals(expected, myList.getReverseList().toString());
	}
	
	@Test
	public void sortedAdd() {
		SortedLinkedList<String> testList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		testList.add("abby").add("d").add("car").add("b");
		
		String expected = "abby, b, car, d";
		
		//System.out.println(testList.toString());
		assertEquals(expected, testList.toString());
		
	}
	
	@Test
	public void sortedRemove() {
		SortedLinkedList<String> testList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		testList.add("a").add("a").add("c").add("a");
		testList.remove("a");
		
		//System.out.println(testList.toString());
		String expected = "c";
		assertEquals(expected, testList.toString());
	}
	
	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void sortedAddToEnd() {
		thrown.expect(UnsupportedOperationException.class);
		thrown.expectMessage("Invalid operation for sorted list.");
		
		SortedLinkedList<String> testList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		testList.add("a").add("b").add("c").add("d");
		testList.addToEnd("e");
	}
	
	@Test
	public void sortedAddToFront() {
		thrown.expect(UnsupportedOperationException.class);
		thrown.expectMessage("Invalid operation for sorted list.");
		
		SortedLinkedList<String> testList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		testList.add("a").add("b").add("c").add("d");
		testList.addToFront("e");
	}
}
