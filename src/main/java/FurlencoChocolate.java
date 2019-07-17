

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FurlencoChocolate {


	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		Task task = new Task();
		final int T = in.readInt();
		for (int t = 0; t <= T - 1; ++t) {
			task.solve(in, out);
		}
		closeStreams(out, in);
	}

	static class Task {


		public void solve(InputReader in, OutputWriter out) {
			int q = in.readInt();
			int k = in.readInt();
			List<Queue<Integer>> queue = new ArrayList<>();
			int count = 0;
			int sum = 0;
			for (int i = 0; i < q; i++) {
				Queue<Integer> qu = new LinkedList<>();
				int n = in.readInt();
				for (int j = 0; j < n; j++) {
					qu.add(in.readInt());
				}
				queue.add(qu);
			}

			while (count < k) {
				int min = Integer.MAX_VALUE;
				int foundAt = 0;
				int inc = -1;
				for (Queue<Integer> data : queue) {
					inc++;
					if (data.peek() != null && data.peek() < min) {
						foundAt = inc;
					}
				}
				if (queue.get(foundAt).peek() != null) {
					sum = sum + queue.get(foundAt).poll();
				}
				count++;
			}
			System.out.println(sum);
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





		public double readDouble() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, readInt());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E') {
						return res * Math.pow(10, readInt());
					}
					if (c < '0' || c > '9') {
						throw new InputMismatchException();
					}
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}





		public long readLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
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





		public String readString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
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





		public String next() {
			return readString();
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





		public static long[] readLongArray(InputReader in, int elementCount) {
			return readLongArray(in, elementCount, 0);
		}





		public static long[] readLongArray(InputReader in, int elementCount, int startOffset) {
			long[] array = new long[elementCount + startOffset];
			for (int i = 0; i < elementCount; i++) {
				array[i + startOffset] = in.readLong();
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
