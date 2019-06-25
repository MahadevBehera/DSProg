import java.util.Scanner;

public class DoubleLinkList {
		static DoubleNode root = null ;
	public static void main(String[] args) {
		
		while (true) {
			int item,loc;
			System.out.println("1. Add an Element .");
			System.out.println("2. Length of List.");
			System.out.println("3. Add an Element at the begin.");
			System.out.println("4. Add an Element after a given location of Node .");
			System.out.println("5. Display the Elements of List...");
			System.out.println("6. Delete Node.. .");
			System.out.println("7. Swap Node.. .");
			System.out.println("8. Reverse the List.. .");
			System.out.println("9. Exit .");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Your Choice .......");
			
			int choice = sc.nextInt();
			switch (choice) {
			case 1: System.err.print("Enter Item :"); 
			        item = sc.nextInt();
			        addElement(item);
			        break;
			        
			case 2: item = length();
					System.out.println(" The Length of List is "+item+"\n");
					break;
					
			case 3: System.err.print("Enter Item :"); 
	        		item = sc.nextInt();
	        		addAtBegin(item);
	        		break;
			
			case 4: System.err.println("Enter Item :"); 
    				item = sc.nextInt();
    				System.err.println("Enter Location");
    				loc = sc.nextInt();
    				AddAfter(item, loc);
    				break;
    				
			case 5: displayElements();
					break;
			
			case 6: System.out.println("Enter Location to Delete ...");
					loc = sc.nextInt();
			  		delete(loc);
					break;
					
			case 7: System.out.println("Enter Location to Swap ...");
					loc = sc.nextInt();
					swap(loc);
					break;
					
			case 8: reverse();
					break;
			
			case 9: System.exit(0);
					break;
					
			default: System.err.println(" Invalid Input ....\n");
					 break;
			}
		
	}

}

	private static void addElement(int item) {
		DoubleNode temp = new DoubleNode(item, null, null);
		
		if (root == null) {
			root = temp;
		}else {
			DoubleNode p = root ;
			while(p.next != null) {
				p = p.next;
			}
			p.next = temp ;
			temp.pre = p ;
			
		}
		System.err.println("Element is added successfully at the End... \n");
	}
	
	private static int length() {
			int count = 0;
			DoubleNode p = root;
			while(p != null){
				p = p.next;
				count++;
			}
		return count;
	}
	
	private static void addAtBegin(int item) {
		DoubleNode temp = new DoubleNode(item, null, null);
		if(root!=null) {
		temp.next = root ;
		root.pre = temp ;
		}
		root = temp ;
		
		System.err.println("Element is added successfully at the Begin... \n");
	}
	
	private static void AddAfter(int item, int loc) {
		int len = length();
		int count = 1;
		DoubleNode temp = new DoubleNode(item, null, null);
		if(len < loc) {
			System.err.println("Invalid location .....\n");
			System.out.println("Currently list having "+len+" no. of Nodes ..\n");
		}else if(len == 0) {
			root = temp;
			System.err.println("The Node is added at begin ... Because the length is "+len);
		}else {
			DoubleNode p = root ;
			
			while(count < loc) {
				p = p.next;
				count ++;
			}
			
			temp.next = p.next ;
			if(p.next != null) { // if user enter last loc then for last node this condition will be false
				p.next.pre = temp ; // otherwise here it will through NullPointerException 
				
			}
			p.next = temp ;
			temp.pre = p ;
			System.err.println(" The Node is added after "+loc +" location ....\n");
		}
		
	}
	
	private static void displayElements() {
		DoubleNode temp = root ;
		if (temp == null) {
			System.out.println(" Currently List is empty .. No element in the List ... \n");
		}else {
			System.out.println(" The Elements Are : ---- \n");
			while (temp != null) {
				System.out.println("Data --"+temp.data);
				temp = temp.next ;
			}
			System.out.println();
		}
	}
	
	
	private static void delete(int loc) {
		int length = length();
		int count = 1 ;
		if(loc > length || loc == 0) {
			System.out.println(" Invalid Location ");
			
		}else if (loc == 1) {
			DoubleNode p = root ;
			root = p.next;
			p.next.pre = null ;
			p.next = null ;
			p = null ;
			System.out.println("The First Node is Deleted Bcoz you entered 1 ....\n");
			
		}else {
			DoubleNode p = root;
			while(count < loc-1) {
				p = p.next;
				count++;
			}
			DoubleNode q = p.next;
			p.next = q.next ;
			if(q.next != null)
				q.next.pre = p ;
			q.next = null;
			q.pre = null;
			q = null ;
			System.out.println("The "+loc+" Node is Deleted ....... \n");
		}
		
	}

	private static void swap(int loc) {
		int length = length();
		int count = 1;
		if(loc > length) {
			System.out.println("Currently List having "+length+" Please Enter valid Location ... \n");
		}else if(loc != length) {
			DoubleNode p = root ;
			while(count < loc -1) {
				p = p.next;
				count++;
			}
			DoubleNode q = p.next;
			DoubleNode r = q.next;
			if( r != null && loc != 1) {
				q.next = r.next ;
				if(r.next != null)
					r.next.pre = q ;
				r.next = q ;
				q.pre = r ;
				p.next = r ;
				r.pre = p;
				System.out.println("The Node is Swaped at "+loc+" location.....\n");
			}else {
				// if list having only two nodes or user enter to swap 1st node
				p.next = q.next ; // null will be swap
				q.next = p ;
				q.pre = p.pre ; // null will be swap
				p.pre = q ;
				root = q ;
				System.out.println("The Node is Swaped at "+loc+" location.....\n");
			}
			
		}else {
			System.out.println("Entered Location is same as Length . Please Enter loc less than length ....\n");
		}
	}
	

	private static void reverse() {
		if(root == null) {
			 System.out.println(" List is Empty Now ..\n");
			 return;
		 }
		int i = 0 ;
		int j = length() - 1;
		
		DoubleNode p = root ;
		DoubleNode q = root ;
		
		while(i < j) {
			if(i == 0) {
			int count = i ; 
			while(count < j) {
				q = q.next ;
				count ++ ;
			}
			}
			Object temp = p.data ;
			p.data = q.data ;
			q.data = temp ;
			
			p = p.next ;
			q = q.pre ;
			i++;
			j--;
			
		}
		 System.out.println("The List is Reversed Now .....\n");
	}




}

class DoubleNode {
	Object data ;
	DoubleNode pre;
	DoubleNode next;
	public DoubleNode(Object data, DoubleNode pre, DoubleNode next) {
		this.data = data;
		this.pre = pre;
		this.next = next;
	}
	
	
	public DoubleNode() {
		
	}
	
}
