import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FurlencoDial {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int weight = Integer.parseInt(br.readLine());

		List<String[]> list = new ArrayList<>();

		for (int i = 1; i <= 12; i++) {
			String l = br.readLine();
			String s[] = l.split(" ");
			list.add(s);
		}
		int res = 0;
		for (String ar[] : list) {
			int max = 0;

			if (Integer.parseInt(ar[0]) > Integer.parseInt(ar[1])) {
				if (weight % 2 == 0) {
					int b = weight / Integer.parseInt(ar[2]);
					max = Integer.parseInt(ar[0]) * b / 2 + Integer.parseInt(ar[1]) * b / 2;
				} else {
					int b = weight / Integer.parseInt(ar[2]);
					max = Integer.parseInt(ar[0]) * b / 2 + 1 + Integer.parseInt(ar[1]) * b / 2;
				}
			} else {
				if (weight % 2 == 0) {
					int b = weight / Integer.parseInt(ar[2]);
					max = Integer.parseInt(ar[0]) * b / 2 + Integer.parseInt(ar[1]) * b / 2;
				} else {
					int b = weight / Integer.parseInt(ar[2]) + 1;
					max = Integer.parseInt(ar[1]) * b / 2 + 1 + Integer.parseInt(ar[0]) * b / 2;
				}
			}

			if (res < max) {
				res = max;
			}
		}
		System.out.println(res);
	}

}
