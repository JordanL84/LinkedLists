package listClasses;

import java.util.*;

/**
 * Implements a generic sorted list using a provided Comparator. It extends
 * BasicLinkedList class.
 * 
 *  @author Dept of Computer Science, UMCP
 *  
 */

public class SortedLinkedList<T> extends BasicLinkedList<T> {
	private Comparator<T> comparator;
	
	public SortedLinkedList(Comparator<T> comparator) {
		super(); //can take this out
		this.comparator = comparator;
	}
	
	public SortedLinkedList<T> add(T element) {
		Node newNode = new Node(element);
		listSize++;
		if (head == null) { //empty list
			head = newNode;
			tail = newNode;
			return this;
		}
		Node prev = null;
		Node curr = head;
		while (curr != null) { //Traverses until last element
			//if new node goes before curr
			if (comparator.compare(curr.data, element) >= 0) { 
				if (curr == head) { //if new node goes first in list
					newNode.next = head;
					head = newNode;
				}
				else {
					prev.next = newNode;
					newNode.next = curr;
				}
				return this;
			}
			else { 
				prev = curr;
				curr = curr.next;
			}
		}
		//if new node goes last
		tail.next = newNode;
		tail = newNode;
		return this;
	}
	
	public SortedLinkedList<T> remove(T targetData) {
		super.remove(targetData, comparator);
		return this;
	}
	
	public BasicLinkedList<T> addToEnd(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	
	public BasicLinkedList<T> addToFront(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
}