package ds.queue;

public class App {

	public static void main(String[] args) {
		Queue queue = new Queue(5);
		
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		queue.insert(5);
		queue.insert(6); // is Full 
		//queue.remove();
		//queue.insert(6);
		queue.view();
		System.out.println(queue.remove());//1
		System.out.println(queue.remove());//2
		System.out.println(queue.remove());//3
		System.out.println(queue.remove());//4
		System.out.println(queue.remove());//5
		System.out.println(queue.remove()); // is Empty
		//System.out.println(queue.remove()); // is Empty
		queue.view(); //[]
		System.out.println("******************************* Random Operations **************************************");
		queue.insert(11);
		queue.insert(22);
		queue.insert(33);
		queue.insert(44);
		queue.insert(55);
		queue.remove(); // removing 11
		queue.insert(66);
		queue.remove();// removing 22
		queue.remove();// removing 33
		queue.insert(77);
		queue.view();
		
	}

}
