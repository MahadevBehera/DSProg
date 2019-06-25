import java.util.Scanner;

public class StackUsingLinkedList {
	static Node top = null;
	public static void main(String[] args) {
		while (true) {
			Object item;
			System.out.println("1. Push the Element .");
			System.out.println("2. Pop the Element .");
			System.out.println("3. Peek the Element .");
			System.out.println("4. Traverse the Stack .");
			System.out.println("5. Exit .");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Your Choice .......");
			
			int choice = sc.nextInt();
			switch (choice) {
			case 1: System.out.print("Enter Item :"); 
			        item = sc.nextInt();
			        push(item);
			        break;
				
			case 2: item=pop();
					if(item != null)
					System.out.println(item +" is Poped from Stack  \n");
	        		break;
	        		
			case 3: item=peek();
					if(item != null)
					System.out.println(item +" is Peeked item .\n");
    				break;
    				
			case 4: traverse();
    				break;
			case 5: System.exit(0);
					break;
			default: System.out.println(" Invalid Input ....\n");
					 break;
			}
		}
	}

	
	private static void push(Object item) {
		Node temp = new Node (item, null);
		temp.link = top ;
		top = temp ;
		
		System.out.println("Node is Pushed ... \n");
	}
	
	private static Object pop() {
		if(top != null) {
		Node temp = top ;
		top = temp.link;
		temp.link = null ;
		Object data = temp.data ;
		temp = null;
		return data ;
		}
		System.out.println(" The Stack is Empty Now .....\n");
		return null;
	}
	
	private static Object peek() {
		if(top != null) {
			return top.data ;
			}
		System.out.println(" The Stack is Empty Now .....\n");
		return null;
	}
	
	private static void traverse() {
		if(top == null) {
			System.out.println("Stack is Empty Now.....\n");
		}else {
			Node temp = top;
			System.out.print("The Elements are : ");
			while(temp != null) {
				System.out.print(temp.data+" ");
				temp = temp.link ;
			}
			System.out.println("\n");
		}
	}

}

