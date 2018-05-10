package stackandqueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	
	private Item[] que;
	private int num; // number of elements on queue
	
	public RandomizedQueue(){
		que = (Item[]) new Object[2];
		num = 0;
	}
	
	public boolean isEmpty(){
		return num == 0;
	}
	
	public int size(){
		return num;
	}
	
	private void resize(int capacity){
		assert capacity >= num;
		Item[] temp = (Item[]) new Object[capacity];
		
		for(int i=0; i<num; i++){
			temp[i] = que[i];
		}
		
		que = temp;
	}
	
	public void enqueue(Item item){
		if(item == null) throw new IllegalArgumentException();
		if(num == que.length) resize(2 * que.length);
		
		que[num++] = item;
	}
	
	// remove and return a random item
	public Item dequeue(){
		if(isEmpty()) throw new NoSuchElementException();
		
		int ch = StdRandom.uniform(num);
		Item it = que[ch];
		
		if(ch != num-1) que[ch] = que[num-1];
		que[num-1] = null; // to avoid loitering
		num--;
		
		if(num > 0 && num == que.length / 4) resize(que.length / 2);
		return it;
	}
	
	// return a random item but not remove it
	public Item sample(){
		if(isEmpty()) throw new NoSuchElementException();
		
		int ch = StdRandom.uniform(num);
		return que[ch];
	}

	// return an independent iterator over items in random order
	public Iterator<Item> iterator() {
		return new RandomizedQueueIterator();
	}
	
	private class RandomizedQueueIterator implements Iterator<Item>{
		
		private Item[] rdq; // independent iterator
		private int current;
		
		public RandomizedQueueIterator(){
			
			rdq = (Item[]) new Object[num];
			current = 0;
			
			for(int k=0; k<num; k++){
				rdq[k] = que[k];
			}
			
			StdRandom.shuffle(rdq);
		}
		
		public boolean hasNext() {return current < num;}
		public void remove() {throw new UnsupportedOperationException();}
			
		public Item next() {
			
			if(!hasNext()) throw new NoSuchElementException();
			
			Item it = rdq[current];
			current++;
			return it;
		}
	}
	
}
