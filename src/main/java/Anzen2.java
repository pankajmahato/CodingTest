import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Anzen2 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Bag<Note> noteBag = new Bag<>();
		Bag<Coin> coinBag = new Bag<>();

		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			String data[] = br.readLine().split(" ");
			if (data[0].equals("Note")) {
				Note note = new Note();
				note.setValue(Integer.parseInt(data[1]));
				noteBag.add(note);
			}
			if (data[0].equals("Coin")) {
				Coin coin = new Coin();
				coin.setValue(Integer.parseInt(data[1]));
				coinBag.add(coin);
			}
		}
		System.out.println("Coins :");
		coinBag.display();
		System.out.println("Notes :");
		noteBag.display();


	}
}

class Note {
	private int val;





	public int getValue() {
		return val;
	}





	public void setValue(int val) {
		this.val = val;
	}


}

class Coin {
	private int val;





	public int getValue() {
		return val;
	}





	public void setValue(int val) {
		this.val = val;
	}


}

class Bag<T> {

	private List<T> list = new ArrayList<>();





	public void add(T t) {
		list.add(t);
	}





	public void display() {

		for (T data : list) {
			if (data instanceof Note) {
				System.out.println(((Note) data).getValue());
			}
			if (data instanceof Coin) {
				System.out.println(((Coin) data).getValue());
			}
		}
	}
}