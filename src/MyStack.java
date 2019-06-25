import java.util.Scanner;

/*Stack Implementation using static array*/

public class MyStack {
	private final static int capacity =5;
	private final static int stack[] = new int[capacity];
	private static int top = -1;
	
	public static void main(String[] args) {
		
		while (true) {
			int item;
			System.out.println("1. Push the Element .");
			System.out.println("2. Pop the Element .");
			System.out.println("3. Peek the Element .");
			System.out.println("4. Traverse the Stack .");
			System.out.println("5. Exit .");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Your Choice .......");
			
			int choice = sc.nextInt();
			switch (choice) {
			case 1: System.out.println("Enter Item :"); 
			        item = sc.nextInt();
			        push(item);
			        break;
				
			case 2: item=pop();
					if(item != 0)
					System.out.println(item +" is Poped from Stack  ");
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

	private static void traverse() {
		
		if(top != -1) {
			System.out.println(" The Elements are ..... ");
		for (int i = 0; i <= top; i++) {
			int j = stack[i];
		
		System.out.println(j);
			
		}
		}else {
			System.out.println(" Stack is Empty ....");
		}
	}

	private static int peek() {
		if(isEmpty()) {
			System.out.println(" The Stack is Empty Now .....");
			return 0;
		}else {
			
		return stack[top];
		}
	}

	private static int pop() {
		if(isEmpty()) {
			System.out.println(" The Stack is Empty Now .....");
			return 0;
		}else {
			
		return stack[top--];
		}
	}

	private static boolean isEmpty() {
		if(top == -1) {
			return true;
		}else {
			return false;
		}
		
	}

	private static void push(int item) {
		if(isFull()) {
			System.out.println(" Stack is Over Flowed....");
		}else {
			top++;
			stack[top]=item;
			System.out.println("The Item is Pushed ..... ");
		}
	}

	private static boolean isFull() {
		if(top == capacity -1) {
			return true;
		}else {
		return false;
		}
	}

}
