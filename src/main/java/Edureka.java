

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

public class Edureka {

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
			int n = in.readInt();
			int data[][] = new int[n][2];
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				data[i][0] = in.readInt();
				data[i][1] = in.readInt();
				if (min > data[i][0]) {
					min = data[i][0];
				}
				if (max < data[i][1]) {
					max = data[i][1];
				}
			}
			int offset = min >= 0 ? 0 : min * -1;
			int graph[];
			if (min < 0) {
				graph = new int[max - min + 1];
			} else {
				graph = new int[max + 1];
			}
			for (int i = 0; i < n; i++) {
				for (int j = data[i][0] + offset; j <= data[i][1] + offset; j++) {
					graph[j] = 1;
				}
			}
			int count = 0;
			for (int i = 0; i < graph.length; i++) {
				if (graph[i] == 1) {
					count++;
				}
			}
			System.out.println(count);
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
