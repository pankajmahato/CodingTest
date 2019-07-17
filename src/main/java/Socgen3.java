

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 * Think you are smart?
A smart-set is a set of distinct numbers in which all the elements have the same number of 1s in their binary form. The set of all smallest elements from each smart-set
that can be formed from a given array of distinct positive numbers is known as the smartest-set.

So given an array of distinct numbers, outline the elements of the smartest-set in ascending sorted order.

Example
Let the array be {6 , 2 , 11 , 1 , 9 , 14 , 13 , 4 , 18}.
In binary form the set is {110, 010, 1011, 0001, 1001, 1110, 1101, 0100, 10010}.
The smart-sets are {1, 2, 4}, {6, 9, 18}, {11, 13, 14}.

The smartest-set is {1,6,11} as each element is the smallest element from each smart-set.

Input Format

The first line of input consists of an integer t. This is the number of test cases. For each test case,
the first line of input contains an integer n. Here n is the number of elements in the array. The next line contains n space separated distinct integers which are the elements
of the array.

Output Format

The output will space separated integer elements of the smartest-set in ascending order.
 * */
public class Socgen3 {


	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		Task task = new Task();
		int T = in.readInt();
		for (int t = 0; t <= T - 1; ++t) {
			task.solve(in, out);
		}
		closeStreams(out, in);
	}


	static class Task {

		int count_one(int x) {
			x = (x & 0x55555555) + (x >> 1 & 0x55555555);
			x = (x & 0x33333333) + (x >> 2 & 0x33333333);
			x = (x & 0x0f0f0f0f) + (x >> 4 & 0x0f0f0f0f);
			x = (x & 0x00ff00ff) + (x >> 8 & 0x00ff00ff);
			x = (x & 0x0000ffff) + (x >> 16 & 0x0000ffff);
			return x;
		}





		int count_ones(int n) {
			int count1 = 0;
			while (n != 0) {
				if (n % 2 != 0) {
					count1++;
				}
				n /= 2;
			}
			return count1;
		}





		public void solve(InputReader in, OutputWriter out) {
			int n = in.readInt();
			Map<Integer, List<Integer>> smart = new HashMap<>();
			for (int i = 0; i < n; i++) {
				int num = in.readInt();
				int count = count_ones(num);
				List<Integer> list = smart.get(count);
				if (list == null) {
					list = new ArrayList<>();
				}
				list.add(num);
				smart.put(count, list);
			}
			List<Integer> result = new ArrayList<>();
			for (Entry<Integer, List<Integer>> entry : smart.entrySet()) {
				List<Integer> value = entry.getValue();
				int min = Integer.MAX_VALUE;
				for (int data : value) {
					if (min > data) {
						min = data;
					}
				}
				result.add(min);
			}
			Collections.sort(result);
			for (int data : result) {
				out.print(data + " ");
			}
			out.printLine();
		}

	}





	private static void closeStreams(OutputWriter out, InputReader in) throws IOException {
		out.flush();
		out.close();
		in.close();
	}

	static class InputReader {

		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;





		public InputReader(InputStream stream) {
			this.stream = stream;
		}





		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}





		public int readInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}





		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}





		public boolean isEndOfLine(int c) {
			if (filter != null) {
				return filter.isEndOfLine(c);
			}
			return c == '\n' || c == '\r' || c == -1;
		}





		public void close() throws IOException {
			this.stream.close();
		}

		public interface SpaceCharFilter {
			boolean isSpaceChar(int ch);





			boolean isEndOfLine(int ch);
		}

	}

	static class IOUtils {

		public static int[] readIntArray(InputReader in, int elementCount) {
			return readIntArray(in, elementCount, 0);
		}





		public static int[] readIntArray(InputReader in, int elementCount, int startOffset) {
			int[] array = new int[elementCount + startOffset];
			for (int i = 0; i < elementCount; i++) {
				array[i + startOffset] = in.readInt();
			}
			return array;
		}


	}

	static class OutputWriter {

		private final PrintWriter writer;





		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}





		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}





		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0) {
					writer.print(' ');
				}
				writer.print(objects[i]);
			}
		}





		public void printLine(Object... objects) {
			print(objects);
			writer.println();
		}





		public void close() {
			writer.close();
		}





		public void flush() {
			writer.flush();
		}

	}
}
