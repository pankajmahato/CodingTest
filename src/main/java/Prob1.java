
public class Prob1 extends Thread {

	@Override
	public void run() {
		System.out.println("sdfsdf");
	}





	public static void main(String args[]) {
		Prob1 test = new Prob1();
		test.start();
		test.setDaemon(true);
	}
}
