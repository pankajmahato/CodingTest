package com.mindtree.test.hcl;

public class PrintSomething implements Runnable {

	private String value;





	public PrintSomething(String value) {
		this.value = value;
	}





	@Override
	public void run() {
		try {
			Thread.sleep((int) (Math.random() * 4000));
		} catch (InterruptedException e) {
		}
		System.out.println(value);
	}





	public static void main(String args[]) {
		Runnable x = new PrintSomething("x");
		Runnable y = new PrintSomething("y");
		Thread one = new Thread(x);
		Thread two = new Thread(y);
		two.start();
		one.start();
	}
}
