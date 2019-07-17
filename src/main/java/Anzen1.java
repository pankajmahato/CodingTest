import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Anzen1 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			Map<Integer, Integer> map = new HashMap<>();

			int a[] = new int[n];
			String line = br.readLine();
			String[] strs = line.trim().split("\\s+");
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(strs[i]);
			}

			printSubsets(a, map);
			int max = map.get(1);
			for (int i = 2; i < map.size(); i++) {
				if (map.get(i) != null && max < map.get(i)) {
					max = map.get(i);
					break;
				}
			}
			System.out.println(max);
		}


	}





	static void printSubsets(int set[], Map<Integer, Integer> map) {
		int n = set.length;

		for (int i = 0; i < 1 << n; i++) {

			int result = 0;
			int count = 0;

			for (int j = 0; j < n; j++) {
				if ((i & 1 << j) > 0) {
					result = result | set[j];
					count++;
				}
			}
			if (count > 0) {
				Integer val = map.get(count);
				if (val != null) {
					if (val > result) {
						map.put(count, result);
					}
				} else {
					map.put(count, result);
				}
			}
		}
	}
}
