package com.mindtree.test.hcl;

class Parent {
	private void privateMEthod() {
		System.out.println("privateMethod in parent");
	}





	public static void staticMethod() {
		System.out.println("staticMethod in parent");
	}





	public void nonStaticMethod() {
		System.out.println("nonStatic method in parent");
	}
}

class Child extends Parent {
	public void childMethod() {
		System.out.println("privateMEthod in child");
	}





	public static void staticMethod() {
		System.out.println("staticMethod in child");
	}





	@Override
	public void nonStaticMethod() {
		System.out.println("Nonstatic in child");
	}
}

public class Testing {
	public static void main(String args[]) {
		Parent parent = new Child();

		//		parent.privateMethod();
		//		parent.childMethod();
		parent.staticMethod();
		parent.nonStaticMethod();
	}
}