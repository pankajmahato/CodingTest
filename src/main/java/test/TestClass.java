package test;

import java.util.Iterator;
import java.util.TreeMap;

class TestClass {

	public void sampleMap() {
		TreeMap tm = new TreeMap();
		tm.put("a", "Hello");
		tm.put("b", "Java");
		tm.put("c", "World");
		Iterator it = tm.keySet().iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
	}





	public static void main(String args[]) throws Exception {
		TestClass junk = new TestClass();
		junk.sampleMap();
	}
}