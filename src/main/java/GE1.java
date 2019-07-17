import java.util.Map;
import java.util.TreeMap;

public class GE1 {
	public static void main(String s[]) {
		Map<String, String> env = System.getenv();


		//		Map<String, String> result = env.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors
		//				.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

		Map<String, String> result = new TreeMap<String, String>(env);

		for (String envName : result.keySet()) {
			System.out.format("%s=%s%n", envName, env.get(envName));
		}
	}

}
