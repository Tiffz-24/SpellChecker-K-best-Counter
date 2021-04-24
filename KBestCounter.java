import java.util.PriorityQueue;
import java.util.*;
public class KBestCounter<T extends Comparable<? super T>> implements KBest<T>{
	private PriorityQueue<T> heap;
	private int k;
	
	public KBestCounter(int k){
	//It should take in an int k that indicates the amount of largest elements you want to return. 
		this.k = k;
		heap = new PriorityQueue<T>(10);
	}
	
	public void count(T x){ 
	//process the next element in the set of data. This operation must run in at worst O(log k) time.
		if(k > heap.size()){
			heap.offer(x);
			
		}
		
		else if(x.compareTo(heap.peek()) > 0){
			heap.poll();
			heap.offer(x);
		}
	}
	
	public List<T> kbest(){
	//return a sorted (smallest to largest) list of the k-largest elements. 
	//This must run in at worst O(k log k) time. The method must not clobber the state of your class. 
	//This means that if you run this method twice in a row, it should return the same values.
		ArrayList<T> list = new ArrayList<T>(heap.size());
		//make sorted list
		int size = heap.size();
		for(int i = 0; i < size; i++){
			list.add(heap.poll());
			
		}
		
		//rebuild heap
		for(int i = 0; i < list.size(); i++){
			heap.offer(list.get(i));
		}
		
		return list;
	}
	
	
	
}
	