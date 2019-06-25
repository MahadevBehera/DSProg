package linked.List.Node;

public class App {

	public static void main(String[] args) {
		//Node Creations
		Node A = new Node(); //1
		A.data = 2;
		
		Node B = new Node(); //2
		B.data = 3;
		
		Node C = new Node(); //3
		C.data = 4;
		
		Node D = new Node(); //4
		D.data = 5;
		
		//Connections (Linkedlist -- Here the Link of Nodes are created )
		A.next = B;
		B.next = C;
		C.next = D;
		
		//finding count of Nodes
		System.out.println(nodeCount(A)); // 4
		System.out.println(nodeCount(B)); //3
		System.out.println(nodeCount(D)); //1
	}
	
	static int nodeCount(Node head) {
		Node temp= head;
		int count = 0;
		if(temp == null) return count;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

}
