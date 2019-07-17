import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GE2 {
	public static void main(String s[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<String, String> map = new HashMap<>();
		int t = Integer.parseInt(br.readLine());
		int total = t;
		while (t-- > 0) {
			int machineCount = Integer.parseInt(br.readLine());

			String m[] = new String[machineCount];
			for (int i = 0; i < machineCount; i++) {
				m[i] = br.readLine();
			}
			int personCount = Integer.parseInt(br.readLine());
			String p[] = new String[personCount];
			for (int j = 0; j < personCount; j++) {
				p[j] = br.readLine();
			}

			for (int i = 0; i < total; i++) {
				map.put(p[0], m[0]);
			}

		}
		for (Entry<String, String> res : map.entrySet()) {
			System.out.println(res.getKey() + "=" + res.getValue());
		}
	}

}
