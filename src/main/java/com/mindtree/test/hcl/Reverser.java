package com.mindtree.test.hcl;

public class Reverser extends Thread {
	private StringBuffer sb;





	public Reverser(StringBuffer sb) {
		this.sb = sb;
	}





	@Override
	public void run() {
		sb.reverse();
	}





	public static void main(String[] args) {
		StringBuffer s = new StringBuffer("xyz");
		Reverser r = new Reverser(s);
		r.start();
		System.out.println(s);
		r.start();
		System.out.println(s);
	}

}
