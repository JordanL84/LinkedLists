package listClasses;

import java.util.*;

public class BasicLinkedList<T> implements Iterable<T> {
	
	/* Node definition */
	protected class Node {
		protected T data;
		protected Node next;

		protected Node(T data) {
			this.data = data;
			next = null;
		}
	}

	/* We have both head and tail */
	protected Node head, tail;
	
	/* size */
	protected int listSize;
	
	public BasicLinkedList() {
		head = null;
		tail = null;
		listSize = 0;
	}
	
	public int getSize() {
		return listSize;
	}
	
	public BasicLinkedList<T> addToEnd(T data) {
		Node newNode = new Node(data);
		if (head == null) { //empty list
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
		listSize++;
		return this;
	}
	
	public BasicLinkedList<T> addToFront(T data) {
		Node newNode = new Node(data);
		if (head == null) { //Empty list
			head = newNode;
			tail = newNode;
		}
		else {
			newNode.next = head; //adds new node before head
			head = newNode;
		}
		listSize++;
		return this;
	}
	
	public T getFirst() {
		if (head == null)
			return null;
		return head.data;
	}
	
	public T getLast() {
		if (head == null)
			return null;
		return tail.data;
	}
	
	public T retrieveFirstElement() {
		if (head == null) //empty list
			return null;
		T target = head.data;
		if (head.next == null) //if there is only one element
			tail = null;
		head = head.next; //head is now equal to second node
		listSize--;
		return target;
	}
	
	public T retrieveLastElement() {
		if (head == null)
			return null;
		T target = tail.data;
		listSize--;
		if (head == tail) { //if there is only one element
			head = null;
			tail = null;
			return target;
		}
		Node curr = head;
		while (curr.next.next != null) { //goes to second to last element
			curr = curr.next;
		}
		//Sets second to last element as new tail
		curr.next = null; 
		tail = curr;
		return target;
	}
	
	public BasicLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		Node prev = null;
		Node curr = head;
		
		while (curr != null) { //Goes until last element
			if (comparator.compare(curr.data, targetData) == 0) { //if curr matches target
				listSize--;
				if (curr == head) { 
					if (head == tail) { //If there is only one element makes list empty
						head = null;
						tail = null;
						return this;
					}
					head = curr.next;
				}
				else if (curr == tail) { //if removing last element
					tail = prev;
					prev.next = null;
				}
				else 
					prev.next = curr.next;
			}
			else
				prev = curr;
			curr = curr.next;
		}
		return this;
	}
	
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node curr = head;
			
			public boolean hasNext() {
				return curr != null;
			}
			
			public T next() {
				T data = curr.data;
				curr = curr.next;
				return data;
			}
			
			public void remove() {
				throw new UnsupportedOperationException("iterator remove not implemented");
			}
		};
	}
	
	public ArrayList<T> getReverseArrayList() {
		ArrayList<T> newList = new ArrayList<T>();
		return getReverseArrayListAux(head, newList);
	}
	
	public ArrayList<T> getReverseArrayListAux(Node headAux, ArrayList<T> list) {
		if (headAux.next == null) { //if last element
			list.add(headAux.data); //adds data to list
			return list;
		}
		getReverseArrayListAux(headAux.next, list); //keeps calling next until reaches last node
		list.add(headAux.data); /*starts from end of list and adds data (starts from
		top of call stack*/
		return list;
	}
	
	public BasicLinkedList<T> getReverseList() {
		BasicLinkedList<T> newList = new BasicLinkedList<T>();
		return getReverseListAux(head, newList);
	}
	
	public BasicLinkedList<T> getReverseListAux(Node headAux, BasicLinkedList<T> list) {
		list.addToFront(headAux.data); //adds data to front
		if (headAux.next == null) { //if last element
			return list;
		}
		return getReverseListAux(headAux.next, list); //will add next node to front
	}
	
	public String toString() {
		String result = "";
		Node curr = head;
		while (curr != null) {
			if (curr == tail) //if last element don't need ,
				result += curr.data;
			else
				result += curr.data + ", ";
			curr = curr.next;
		}
		return result;
	}
}