package adt.stack;

public class Stack {
	private int size ;
	private char chArray[];
	private int top ;
	
	public Stack(int size) {
		this.size = size;
		chArray = new char[this.size];
		top = -1;
	}
	
	public void push(char ch) {
		if(isFull()) {
			System.out.println("***************** The Stack is Full Now *****************\n");
		}else {
		top++;
		chArray[top]= ch;
		}
	}
	
	public char pop() {
		if(isEmpty()) {
			System.out.println("***************** The Stack is Empty Now ****************\n");
			return ' ';
		}else {
		char data = chArray[top];
		top--;
		return data;
		}
	}
	
	public char peek() {
		if(isEmpty()) {
			System.out.println("***************** The Stack is Empty Now ****************\n");
			return ' ';
		}else {
		return chArray[top];
		}
	}
	
	public boolean isFull() {
		return top == size-1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}

}
