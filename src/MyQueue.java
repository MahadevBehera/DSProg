import java.util.Scanner;

public class MyQueue {
	
	private static final int CAPACITY = 5;
	private static final int queue[] = new int[CAPACITY];
	private static final int front = 0;
	private static int rare = 0;

	public static void main(String[] args) {
		while (true) {
			int item;
			System.out.println("1. Insert the Element .");
			System.out.println("2. Delete the Element .");
			System.out.println("3. Peek the Element .");
			System.out.println("4. Traverse the Stack .");
			System.out.println("5. Exit .");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Your Choice .......");
			
			int choice = sc.nextInt();
			switch (choice) {
			case 1: System.out.println("Enter Item :"); 
			        item = sc.nextInt();
			        insert(item);
			        break;
				
			case 2: item=delete();
					if(item != 0)
					System.out.println(item +" is Deleted from Queue  ");
	        		break;
	        		
			case 3: item=peek();
					if(item != 0)
					System.out.println(item +" is Peeked item .");
    				break;
    				
			case 4: traverse();
    				break;
			case 5: System.exit(0);
					break;
			default: System.out.println(" Invalid Input ....");
					 break;
			}
		}

	}

	
	

	private static void insert(int item) {
		if(rare == CAPACITY) {
			System.out.println("The Queue is full now ....\n");
		}else {
			queue[rare] = item ;
			rare++;
			System.out.println("The item is inserted into Queue .....\n");
		}
	}
	
	private static int delete() {
		if( rare == front) {
			System.out.println("The Queue is Empty now ...\n");
		}else {
			int deleted= queue[front];
			for(int i = 0 ; i < queue.length -1 ; i++) {
				queue[i] = queue[i+1];
			}
			rare-- ;
			return deleted ;
		}
		return 0;
	}
	
	private static int peek() {
		if(rare == front) {
			System.out.println("The Queue is Empty now ...\n");
		}else {
			return queue[front];
		}
		return 0;
	}

	private static void traverse() {
		if( rare == front) {
			System.out.println("The Queue is Empty now ...\n");
		}else {
			System.out.println("The Datas are ---- ");
			for(int i = 0 ; i < rare ; i++) {
				System.out.print(queue[i]+" ");
			}
			System.out.println("\n");
		}
		
	}





}
