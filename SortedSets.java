/**
 *  Methods to perform Set operations on List(Both ArrayList and LinkedList)
 *  The method OPERATION takes three parameters, performs the operation on the first 2 and 
 *  store the result in the third paramater.
 *  Here OPERATION = {intersect, union, difference}
 *  @author  Parikshit Janagama, Subrahmanyam Oruganti,  Phani Kiran Thaticharla, Sriharsha Thota, 
 *
 */
package cs6301.g30;

import cs6301.g00.Timer;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class SortedSets{

	public static<T extends Comparable<? super T>> void intersect(List<T> l1, List<T> l2, List<T> outList) {
		
		/*
		 * This method has 2 iterators, which go through the lists simultaneously comparing their current elements.
		 * IF the elements are same, then its added to the outList and both iterators are moved forward. If they are different, 
		 * the shorter elements iterator is moved to the next element. The method ends if one of the iterator reached its end
		 */
		
		
		Iterator<T> I1 = l1.iterator();
		Iterator<T> I2 = l2.iterator();
		T temp1 = I1.next();
		T temp2 = I2.next();
		while(true){		
			if(temp1.compareTo(temp2) == 0){
				outList.add(temp1);
				if(I1.hasNext() && I2.hasNext()){
					temp1 = I1.next();
					temp2 = I2.next();
				} else {
					break;
				}
				
			} else if(temp1.compareTo(temp2) < 0) {
				if(I1.hasNext()){
					temp1 = I1.next();
				} else {
					break;
				}
			} else {
				if(I2.hasNext()){
					temp2 = I2.next();
				} else {
					break;
				}			}

		}
		
/**
 * Size		LL		AL
 * 100k		8		9
 * 1M		18		18
 * 10M		117		59
 * 16M		166		78 
 */
	
		
	}
	
	
	public static<T extends Comparable<? super T>> void union(List<T> l1, List<T> l2, List<T> outList) {
		/*
		 * This method has 2 iterators, which go through the lists simultaneously comparing their current elements.
		 * IF the elements are same, then its added to the outList and both iterators are moved forward. If they are different, 
		 * the shorter element is added to the outList and only its iterator is moved to the next element. 
		 * The method ends only after both the iterator reach their end
		 */
		
		Iterator<T> I1 = l1.iterator();
		Iterator<T> I2 = l2.iterator();
		T temp1 = I1.next();
		T temp2 = I2.next();
		while(true){
			if(temp1.compareTo(temp2) == 0){
				outList.add(temp1);		
				if(I1.hasNext() && I2.hasNext()){
					temp1 = I1.next();
					temp2 = I2.next();
				} else {
					if(I1.hasNext()){
						while(I1.hasNext()){
							temp1 = I1.next();
							outList.add(temp1);
							}
					} else if(I2.hasNext()){
						while(I2.hasNext()){
							temp2 = I2.next();
							outList.add(temp2);
							}
					}
					break;
				}
			} else if(temp1.compareTo(temp2) < 0){
				outList.add(temp1);
				if(I1.hasNext()){
					temp1 = I1.next();
				} else {
					outList.add(temp2);
					if(I2.hasNext()){
						while(I2.hasNext()){
							temp2 = I2.next();
							outList.add(temp2);
							}
					}
					break;
				}
			} else if(temp1.compareTo(temp2) > 0){
				outList.add(temp2);
				if(I2.hasNext()){
					temp2 = I2.next();
				} else {
					outList.add(temp1);
					if(I1.hasNext()){
						while(I1.hasNext()){
							temp1 = I1.next();
							outList.add(temp1);
							}
					}
					break;
				}
				}
			}
		
/**
 * Size		LL		AL
 * 10k		3		2
 * 100k		18		16
 * 1M		29		26
 * 10M		438		90
 * 16M		7659	133 
 */
	}
	
	
	
	public static<T extends Comparable<? super T>> void difference(List<T> l1, List<T> l2, List<T> outList) {
		/*
		 * This method has 2 iterators, which go through the lists simultaneously comparing their current elements.
		 * IF the elements are same, then both iterators are moved forward. If they are different and the element 
		 * of the first list is shorter then its added to the outList and only its iterator is moved to the next element. 
		 * If the first element is bigger, then the iterator of the second list moves forward. 
		 * The method ends after the first iterator reaches its end.
		 */
		
		Iterator<T> I1 = l1.iterator();
		Iterator<T> I2 = l2.iterator();
		T temp1 = I1.next();
		T temp2 = I2.next();
		while(true){
			if(temp1.compareTo(temp2) < 0){
				outList.add(temp1);
				if(I1.hasNext()){
					temp1 = I1.next();
				} else {
					break;
				}
			} else if(temp1.compareTo(temp2) == 0){
				if(I1.hasNext() && I2.hasNext()){
					temp1 = I1.next();
					temp2 = I2.next();
				} else {
					if(I1.hasNext()){
						while(I1.hasNext()){
							temp1 = I1.next();
							outList.add(temp1);
							}
					} else if(I2.hasNext()){
						break;
					}
					break;
				}
			} else if(temp1.compareTo(temp2) > 0){
				if(I2.hasNext()){
					temp2 = I2.next();
				} else {
					outList.add(temp1);
					while(I1.hasNext()){
						temp1 = I1.next();
						outList.add(temp1);
						}
					break;
				}
			}
		}
	}


	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		List<Integer> outList = new ArrayList<>();
		int n = 100000;
		int n1 = 2;
		int n2 = 3;
		for(int i = 0; i <= n; i = i + n1)
			l1.add(i);
		
		for(int i = 0; i <= n; i = i + n2)
			l2.add(i);
		
		/*		for(int i = 0; i < l1.size(); i++)
		System.out.println(l1.get(i));
		
	for(int i = 0; i < l2.size(); i++)
		System.out.println(l2.get(i));

*/		Timer t = new Timer();
		t.start();
		difference(l1, l2, outList);
		System.out.println(t.end());
		System.out.println("Size of Difference            : "+ outList.size());
		//int n3 = (n/n1 + 1) + (n/n2 + 1) - n/(n2*n1) - 1; 
		if(n1 == n2){
			//System.out.println("Expected Size of Union: "+ (n/n1 + 1));
		}
		System.out.println("Expected Size after Difference: "+ (n/n1 - n/(n2*n1)));
	
		/*
		for(int i = 0; i < outList.size(); i++)
			System.out.println(outList.get(i));
		*/
	}
}
