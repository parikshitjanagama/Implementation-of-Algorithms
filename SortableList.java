/**
 *  Method to perform MergeSort on Lists created using the SinglyLinkedList class
 *  Program returns a sorted list when inputed with an unsorted List.  
 *  @author  Parikshit Janagama, Subrahmanyam Oruganti,  Phani Kiran Thaticharla, Sriharsha Thota, 
 *
 */
package cs6301.g30;

import java.util.Iterator;


import cs6301.g00.Shuffle;
import cs6301.g30.SinglyLinkedList;
import cs6301.g00.Timer;

public class SortableList<T extends Comparable<? super T>> extends SinglyLinkedList<T> {
	SortableList<T> list;
	
	/*
	 * Method called to perform the Merge Sort
	 */

    public static<T extends Comparable<? super T>> void mergeSort(SortableList<T> lst) {
	lst.mergeSort();
    }

	/*
	 * Internal method called to perform the actual Sorting
	 * The list is recursively split in two halves by pointing a new node, to the node in the middle and 
	 * pointing its(middle) previous node to null, thus creating two half lists. 
	 * These two halves are sorted separately and Merged into a single sorted List
	 * If size of array is < 3, then the are sorted directly by comparison.
	 */
    void mergeSort() {// Sort this list
    	list = this;
    	int size = list.size;
    	Iterator<T> it = list.iterator();
    	if(size >= 2){
    		if(size == 2){
        		if(list.head.next.element.compareTo(list.tail.element) > 0){
        			list.tail = list.head.next;
        			list.head.next = list.tail.next;
        			list.tail.next = null;
        			list.head.next.next = list.tail;
        		}
    		} else{
	    	int q = size/2;
	    	int i = 1;
	    	while(i< q){
	    		it.next();
	    		i++;
	    	}
	    	SortableList<T> list1 = new SortableList<T>();
	    	list1.size = size-q;
	    	list.size = q;
	    	list.tail = ((SortableList<T>.SLIterator<T>) it).nextEntry();
	    	list1.head.next = ((SortableList<T>.SLIterator<T>) it).nextEntry();
	    	list.tail.next = null;   	
	    	list1.tail = list.tail;
	    	list.mergeSort();
	    	list1.mergeSort();
	    	list.merge(list1);
	    	//list.printList();
	    	list.size = list.size + list1.size;
    	}
    	}
    	
    }
    
    
	/*
	 * This method Merges a split List back in a sorted order
	 * We iterate through the first list and compare the current element with the head of the second list. 
	 * If the element in first list is smaller, we move to the next element and compare again. 
	 * If the element in second list is smaller, we insert that node at the current point in the first list 
	 * and point the header to the next element and compare again.
	 * 
	 */

    void merge(SinglyLinkedList<T> list1) {  // Merge this list with other list
    	list = this;
    	Entry<T> E = list.head;
    	Entry<T> temp;
    	while(true){
    		if(E.next.element.compareTo(list1.head.next.element) > 0){
    			temp = E.next;
    			E.next = list1.head.next;
    			if(list1.head.next.next ==null){
    				E.next.next = temp;
    				break;
    			}
    			list1.head.next = list1.head.next.next;
    			E.next.next = temp;
    		} else {
    			if(E.next.next == null){
    				E.next.next = list1.head.next;
    				break;
    			} else {
    				E = E.next;
    			}	
    		}
    	}
    }

    public Iterator<T> iterator() { return new SLIterator<>(this); }
    
    public class SLIterator<E> extends SLLIterator<E>{
    	/*
    	 * Iterator used to move along the list and return the next node instead of the element.
    	 */

		SLIterator(SinglyLinkedList<E> list) {
			super(list);
		}
		
		public Entry<E> nextEntry() {
		    prev = cursor;
		    cursor = cursor.next;
		    ready = true;
		    return cursor;
		}
    	
    }

	public static void main(String[] args) {
		int n = 10;
		int[] a1 = new int[n];
		for(int i = 0; i < a1.length; i++){
			a1[i] = i+1;
		}
		Shuffle.shuffle(a1);
		SortableList<Integer> lst = new SortableList<>();
	    for(int i=1; i<=a1.length; i++) {
	       	lst.add(new Integer(a1[i-1]));
	    }
	    lst.printList();
	    Timer t = new Timer();
	    t.start();
	    mergeSort(lst);
	    System.out.println(t.end());
        lst.printList();
	}
}
