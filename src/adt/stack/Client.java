package adt.stack;

public class Client {

	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.push('A');
		stack.push('B');
		stack.push('C');
		stack.push('D');
		stack.push('E');
		stack.push('F');
		while(!stack.isEmpty()) {
			char data = stack.pop();
			System.out.println(" **** "+data+" **** ");
		}
		stack.pop();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		String newStr = reverse("HELLO Guys , How are you ?");
		System.out.println(newStr);
	}
	
	// Reverse a string using Stack Data Structure
	
	public static String reverse(String str) {
		Stack stack = new Stack(str.length());
		for(int i = 0; i< str.length(); i++ ) {
			stack.push(str.charAt(i));
		}
		str = "";
		while(!stack.isEmpty()) {
			str = str + stack.pop();
		}
		return str;
	}

}
