package com.hackerrank.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

class Stack {

	private int arr[];
	private int size;
	private int index = 0;





	public Stack(int size) {
		this.size = size;
		arr = new int[size];
	}





	public void push(int element) {

		if (isFull()) {
			throw new StackOverflowError("Stack is full");
		}

		arr[index] = element;
		index++;
	}





	public int pop() {

		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return arr[--index];
	}





	public boolean isEmpty() {
		if (index == 0) {
			return true;
		}
		return false;
	}





	public boolean isFull() {
		if (index == size) {
			return true;
		}
		return false;
	}





	public int size() {
		return index;
	}
}

public class StackClient {


	public static void main(String args[]) {
		ArrayList<String> operations = new ArrayList<>();
		operations.add("push 4");
		operations.add("pop");
		operations.add("push 3");
		operations.add("push 5");
		operations.add("push 2");
		operations.add("inc 3 1");
		operations.add("pop");
		operations.add("push 1");
		operations.add("inc 2 2");
		operations.add("push 4");
		operations.add("pop");
		operations.add("pop");

		Stack stack = new Stack(1000);
		int size = 0;
		for (int i = 0; i < operations.size(); i++) {

			if (operations.get(i).contains("push")) {
				int number = Integer.parseInt(operations.get(i).substring(operations.get(i).indexOf(" ") + 1));
				stack.push(number);
				size++;
				System.out.println(number);
			} else if (operations.get(i).contains("pop")) {
				stack.pop();
				if (stack.isEmpty()) {
					System.out.println("EMPTY");
				} else {
					int number = stack.pop();
					stack.push(number);
					System.out.println(number);
				}
				size--;
			} else if (operations.get(i).contains("inc")) {
				Stack stackTemp = new Stack(1000);
				int firstPart = operations.get(i).indexOf(" ");
				int secondPart = operations.get(i).indexOf(" ", firstPart + 1);
				int first = Integer.parseInt(operations.get(i).substring(firstPart + 1, secondPart));
				int second = Integer.parseInt(operations.get(i).substring(secondPart + 1));
				for (int j = 0; j < size; j++) {
					if (j < size - first) {
						stackTemp.push(stack.pop());
					} else {
						stackTemp.push(stack.pop() + second);
					}
				}
				for (int j = 0; j < size; j++) {
					stack.push(stackTemp.pop());
				}
				int number = stack.pop();
				stack.push(number);
				System.out.println(number);
			}
		}
		//		System.out.println(stack);
	}
}
