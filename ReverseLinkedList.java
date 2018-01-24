/**
 *  Methods to reverse a LinkedList form SinglyLinkedList class with and without recursion. 
 *  The method  reverseLinkedList() takes a SinglyLinkedList and reverses the List non recursively.
 *  The method  recursiveRLL() takes a SinglyLinkedList and reverses the List recursively.
 *  @author  Parikshit Janagama, Subrahmanyam Oruganti,  Phani Kiran Thaticharla, Sriharsha Thota, 
 *
 */



package cs6301.g30;

import cs6301.g30.SinglyLinkedList;
import cs6301.g30.SinglyLinkedList.Entry;

public class ReverseLinkedList {
	public <T> void reverseLinkedList(SinglyLinkedList<T> list){
		/*
		 * Loop invariant: The elements from the List are taken in order and are added at the beginning of a new list.
		 * This will reverse the direction of the pointers, there by reversing the List, 
		 * as the next node{of current node) will be added in front of the current node in the new List 
		 * 
		 * The method takes a SinglyLinkedList and reverses is by iterating through the current List and 
		 * storing the elements in a reverse order, by adding the current element to the head of the new list.
		 * 
		 */
		
		SinglyLinkedList<T> rList = new SinglyLinkedList<>();
		if(list.head.next == null){
			return;
		} 
		if(list.head.next.next == null){
			return;
		}
		Entry<T> E = list.head.next;
		Entry<T> temp = E.next;
		
		while(true){
			E.next = rList.head.next;
			rList.head.next = E;
			E = temp;
			if(E != null){
			temp = temp.next;
			} else {
				break;
			}
		}
		list.head = rList.head;
		
	}
	
	<T> void recursiveRLL(SinglyLinkedList<T> list){
		list.head.next = recursiveRLL(list.head.next);
	}
	
	/*
	 * Loop Invariant: This method recursively calls the next element till it reaches the end, 
	 * store it and points this to the current element and the current element, to null.
	 * This method recursively reverses the List
	 */
	
	public static <T> Entry<T> recursiveRLL(Entry<T> E){
		if(E.next == null | E == null){
			return E;
		} else {
		Entry<T> E1 = recursiveRLL(E.next);
		E.next.next = E;
		E.next = null;
		 return E1;
		}
		
	}
}
