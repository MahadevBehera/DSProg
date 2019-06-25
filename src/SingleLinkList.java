import java.util.Scanner;

public class SingleLinkList {
	static Node root = null;
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
			System.out.println("Enter Your Choice .......");
			
			int choice = sc.nextInt();
			switch (choice) {
			case 1: System.out.println("Enter Item :"); 
			        item = sc.nextInt();
			        addElement(item);
			        break;
			        
			case 2: item = length();
					System.out.println(" The Length of List is "+item+"\n");
					break;
					
			case 3: System.out.println("Enter Item :"); 
	        		item = sc.nextInt();
	        		addAtBegin(item);
	        		break;
			
			case 4: System.out.println("Enter Item :"); 
    				item = sc.nextInt();
    				System.out.println("Enter Location");
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
					
			default: System.out.println(" Invalid Input ....");
					 break;
			}
		}
		
	}


	static void addElement(Object item) {
		Node temp = new Node(item,null);
		if(root == null) {
			root= temp;
		}else {
			Node p = root;
			while(p.link != null) {
				p = p.link;
			}
			p.link = temp;
			
		}
		System.out.println("Element is Added at the End of List.... \n");
	}
	
	static int length() {
		int counter = 0;
		Node temp = root ;
		while ( temp != null) {
			counter++;
			temp = temp.link;
			
		}
		return counter;
	}
	
	static void addAtBegin(Object item){
		Node temp = new Node(item, null);
		
		if(root != null) {
			temp.link = root;  // always 1st (right side connection)
			root = temp ;      // always 2nd (left side connection)
		}else {
			root = temp;
		}
		System.out.println(" Element is Added at the Begin of List ..... \n ");
	}
	
	static void AddAfter(Object item, int loc) {
		int count = 1;
		Node temp = new Node(item, null);
		int length = length();
		
		if(length < loc) {
			System.out.println(" Invalid Location ");
			System.out.println(" Currently list is having "+length+ " Nodes....\n");
		}else if(length == 0) {
			root = temp;
			System.out.println(" The Element is added at Begin Because the length of List is 0 now.. \n");
		}else {
			Node p = root ; 
			while(loc > count){
				p = p.link;
				count ++;
				}
			
			// If user enter 0 and i want to add that element at the beginning of list
			if(loc == 0) {
				temp.link = root; // always 1st (right side connection)
				root = temp;      // always 2nd (left side connection)
			System.out.println(" The Element is added at the begin because you enter the location as 0 \n");
			}else {
			temp.link = p.link;  // always 1st (right side connection)
			p.link = temp;       // always 2nd (left side connection)
			
			System.out.println(" The Element is added After "+loc +" location \n");
			
			}
		}
	}
	
	static void displayElements() {
		if(root == null) {
			System.out.println(" There is no Elements to Display .....\n");
		}else {
			Node temp = root ;
			System.out.println(" The Elements are ..... :\n");
			while(temp != null) {
				System.out.println("Data : "+temp.data+"\n");
				temp = temp.link;
			}
		}
	}
	
	
	 static void delete(int loc) {
		 int length = length();
		 int count = 1;
		 if(length < loc || loc == 0) {
			 System.out.println("Invalid Location ... ");
		 }else if(loc ==1) {
			 Node temp = root ;
			 root = temp.link;
			 temp.link = null;
			 temp = null;
			 System.out.println("The First Node is Deleted Bcoz you entered 1 ....\n");
		 }else {
			 Node p = root;
			 while(count < loc -1) {
				 p = p.link;
				 count++;
			 }
			 Node q = p.link;
			 p.link = q.link;
			 q.link = null ;
			 q = null;
			System.out.println("The "+loc+" Node is Deleted ....... \n"); 
			 
		 }
	}
	 
	 static void swap(int loc) {
		 int count = 1;
		 int len = length();
		 if(root == null) {
			 System.out.println("Currently List is Empty ...\n");
		 }
		 else if (len< loc) {
			 System.out.println("Currently List having "+len+" Please Enter valid Location ... \n");
		 }else if(len != loc){ // condition for last node if user enter loc of last node
			 Node p = root;
			 while(count < loc-1) {
				 p = p.link;
				 count++;
			 }
			 Node q = p.link;
			 Node r = q.link;
			if(r != null && loc != 1) {
			 q.link = r.link;
			 r.link = q ;
			 p.link = r ;
			 } else { 
				 // if list having only two nodes or user enter to swap 1st node
				 p.link = q.link;
				 q.link = p;
				 root = q;
			
			 }
		System.out.println("The Node is Swaped .....\n");
		 }else {
			 System.out.println("Entered Location is same as Length . Please Enter loc less than length ....\n");
		 }
		 
		}
	 
	 private static void reverse() {
		 if(root == null) {
			 System.out.println(" List is Empty Now ..\n");
			 return;
		 }
		 int i = 0;
		 int j = length() - 1 ;
		 
		 Node p = root ;
		 Node q = root ;
		 
		 while(i < j) {
			 int count = i;
			 while(count < j) {
				 q = q.link ;
				 count ++ ;
			 }
			 Object temp = p.data ;
			 p.data = q.data ;
			 q.data = temp ;
			 
			 p = p.link;
			 q = p;
			 i++;
			 j--;
		 }
		 System.out.println("The List is Reversed Now .....\n");
		}



}


class Node{
	
	Object data;
	Node link;
	
	public Node() {}
	public Node(Object data, Node link) {
		this.data = data;
		this.link = link;
	}
	
	
}
