
class Test1 implements Runnable {
	Thread t1, t2;





	Test1() {
		t1 = new Thread(this, "Thread_1");
		t2 = new Thread(this, "Thread_2");
	}





	@Override
	public void run() {
		t2.setPriority(Thread.MAX_PRIORITY);
		System.out.println(t1.equals(t2));

	}

}

public class Test {
	public static void main(String args[]) {
		new Test1();
	}
}