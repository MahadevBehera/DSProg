package ds.queue;
// Implementation Of Queue Data Structure using Array and the logic of Cyclic Queue concept
public class Queue {
	private int maxSize;
	private long arr[];
	private int front;
	private int rare;
	private int items;

	public Queue(int maxSize) {
		this.maxSize = maxSize;
		this.arr = new long[this.maxSize];
		this.front = 0;
		this.rare = -1;
		this.items = 0;
	}

	public void insert(long data) {
		if(isFull()) {
			System.out.println("*********** Queue is Full Now *********");
			return;
		}
		if(this.rare == this.maxSize -1) {
			this.rare = -1; // Cyclic Queue using for inserting elements  
		}
		this.rare++;
		this.arr[this.rare] = data;
		this.items++;
	}

	public long remove() {
		if(isEmpty()) {
			System.out.println("*********** Queue is Empty Now *********");
			return 0;
		}
		if(this.front == this.maxSize) {
			this.front = 0; // Cyclic Queue using for removing elements from beginning of index (from 0th index)
		}
		long temp = this.arr[this.front];
		this.front++; // Don't try to swap all elements instead of increase front by 1 , its easy and less costly code (Optimized)
		this.items--;
		return temp;
	}
	
	public long peek() {
		return this.arr[this.front];
	}

	public boolean isFull() {
		return this.items == this.maxSize;
	}

	public boolean isEmpty() {
		return this.items == 0;
	}
	
	public void view() {
		System.out.print("[ ");
		if(!isEmpty()) { // if there are elements in the Queue
		for (int i = this.front; i < arr.length; i++) {
			if(this.rare > this.front && i == this.rare+1) break; // if rare is pointing to the index which is less than (maxSize-1)
				System.out.print(this.arr[i]+" ");                   // then no need to run the loop upto (arr.length-1)/(maxSize-1)
		}
		if(this.rare < this.front) { // if rare is pointing to the index which is lesser than front index becoz of cyclic queue
			for (int j = 0; j <= this.rare; j++) {
				System.out.print(this.arr[j]+" ");	
			}
		}
		}
		System.out.println("]");
	}
}
