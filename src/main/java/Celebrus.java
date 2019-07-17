

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;
import java.util.Stack;


/**
 * Don’t be afraid of the Dark

Avin is a night duty warden in a hostel. One day, due to fluctuations in the electricity, all the MCB switches went off. He has a major phobia with darkness. But lucky for him, when the world went dark, he was standing at one of the corridor ends. He lights this up without a further thought. He then lights up the corridor ends that are closest to those already lit. This is to ensure that the distance he travels in the dark is “minimized” in a certain sense. I know this statement is cryptic, so it’s perhaps best explained with an aid of an example.

Example
Suppose the hostel at which Avin works looks like this:

hostel looks like this

Let the position of Avin be at corridor end 1. He lights it up. The corridor end that is closest to him is 2 that is 30 m away. (The numbers represent distances in metres).
So he lights 2.

After switching on light 2, 1 and 2 are lit. They are connected to 3, 5 and 4. The closest is 5. This is 20 m away from 2.
So he switches on the light at 5.

Next, the closest end connected to one of 1, 2 and 5 that is unlit is 3. It is 40 m away from 1. So he switches on the light at 3.

Now 4 is left. And it’s 60 m away from 2.

All in all the length of the paths of corridors he has “selected” while they are unlit is 30 m -> 20 m -> 40 m -> 60 m.

So given a map of the hostel, and Avin’s location, output the lengths of paths as space separated integers such that the distance he travels in the dark is minimized. The input and output formats are outlined below:

Input Format
The first line of input consists of an integer t. This is the number of test cases. For each test case, the first line of input contains n and m. Here n is the number of corridor ends and m denotes the number of corridors.
The next m lines consists of three space separated integers x y z. x and y are the end points of the corridor and z is the length of the corridor.
The last line of each test case is an integer denoting the position of Avin.

Output Format
The output will be space separated integers denoting the lengths of paths he’s selected in order.

Constraints
0 < t < 200 (This is the number of test cases)
2 < n < 200 (This is the number of endpoints of corridors in the hostel)
n < m < nC2
1 <= x,y <= n
0 < z < 1000 (This is the maximum length of the corridor)

Sample input :
1
5 6
1 2 30
2 4 60
1 3 40
2 3 50
3 5 70
2 5 20
1
Sample Output :
30 20 40 60
Note
The sample test case is explained in the above example. There can be cases where the hostel contains disconnected portions that cannot be lit up by Avin.
 * */
public class Celebrus {


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

		private int numberOfNodes;
		private static Stack<Integer> stack;


		static {
			stack = new Stack<>();
		}





		public void tsp(int start, int adjacencyMatrix[][], InputReader in, OutputWriter out) {
			numberOfNodes = adjacencyMatrix[1].length - 1;
			int[] visited = new int[numberOfNodes + 1];
			visited[1] = 1;
			stack.push(start);
			int element, dst = 0, i;
			int min = Integer.MAX_VALUE;
			boolean minFlag = false;
			out.print(start + " ");

			while (!stack.isEmpty()) {
				element = stack.peek();
				i = 1;
				min = Integer.MAX_VALUE;
				while (i <= numberOfNodes) {
					if (adjacencyMatrix[element][i] > 1 && visited[i] == 0) {
						if (min > adjacencyMatrix[element][i]) {
							min = adjacencyMatrix[element][i];
							dst = i;
							minFlag = true;
						}
					}
					i++;
				}
				if (minFlag) {
					visited[dst] = 1;
					stack.push(dst);
					System.out.print(dst + "\t");
					minFlag = false;
					continue;
				}
				stack.pop();
			}
		}





		public void solve(InputReader in, OutputWriter out) {
			int n = in.readInt();
			int m = in.readInt();
			int adjacency_matrix[][] = new int[n + 1][m + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					adjacency_matrix[i][j] = in.readInt();
				}
			}
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0) {
						adjacency_matrix[j][i] = 1;
					}
				}
			}
			int start = in.readInt();
			Task task = new Task();
			task.tsp(start, adjacency_matrix, in, out);
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
