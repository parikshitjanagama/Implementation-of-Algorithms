/**
 *  Methods to print a LinkedList form SinglyLinkedList class in reverse with and without recursion. 
 *  The method  printReverseList() takes a SinglyLinkedList and prints the List in reverse non recursively.
 *  The method printRecursiveReverseList() takes a SinglyLinkedList and prints the list in reverse recursively.
 *  @author  Parikshit Janagama, Subrahmanyam Oruganti,  Phani Kiran Thaticharla, Sriharsha Thota, 
 *
 */
package cs6301.g30;

import java.util.Stack;

import cs6301.g30.SinglyLinkedList;
import cs6301.g30.SinglyLinkedList.Entry;

public class PrintReverseList<T> {
	//Calls the recursive function by passing the head of list as parameter
	void printRecursiveReverseList(SinglyLinkedList<T> list){
		printRecursiveReverseList(list.head.next);
		} 
	
	/*
	 * Loop Invariant: This method recursively calls the next element till it reaches the end, 
	 * and prints them once it reaches the end in the order they were stacked.
	 * This method recursively prints the List in reverse.
	 */
	 private void printRecursiveReverseList(Entry<T> E) {	
		if(E == null){
			return;
		}
		printRecursiveReverseList(E.next);
		System.out.print(E.element + " ");
		
	}
	 
	 /*
	  * Loop Invariant: This method adds the elements in order to a stack till the list is fully added,
	  * and prints them in order from the stack, there by reversing the order of the list.
	  */
	void printReverseList(SinglyLinkedList<T> list){
		Entry<T> E = list.head.next;
		Stack<T> S = new Stack<>();
		while(E != null){
			S.push(E.element);
			E = E.next;
		}
		while(!S.isEmpty())
		System.out.print(S.pop() + " ");
	 }
}
