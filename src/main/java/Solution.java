import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

class Solution {


	public static void main(String[] args) throws IOException {
		Reader a = new Reader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		//Scanner a = new Scanner(System.in);

		int test = a.nextInt();
		while (test-- > 0) {
			int n = a.nextInt();
			String name = a.nextString();
			long one = 0, zero = 0;
			for (int i = 0; i < n; i++) {
				StringBuilder s = new StringBuilder(a.nextString());
				for (int j = 0; j < s.length(); j++) {
					if (s.charAt(0) == '1' && s.charAt(j) == '1')
						one++;
					if (s.charAt(0) == '0' && s.charAt(j) == '0')
						zero++;
				}
			}
			//out.println(one+" "+zero);
			if (name.equals("Dee") && zero <= one)
				out.println("Dum");
			else if (name.equals("Dee") && zero > one)
				out.println("Dee");
			else if (name.equals("Dum") && zero >= one)
				out.println("Dee");
			else if (name.equals("Dum") && zero < one)
				out.println("Dum");
		}

	}

	//--------------------------FAST IO-------------------------------------------------//
	private static class Reader {
		private InputStream stream;
		private byte[] buf = new byte[4 * 1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;





		public Reader(InputStream stream) {
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





		public int nextInt() {
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





		public String nextString() {
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





		public double nextDouble() {
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
					return res * Math.pow(10, nextInt());
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
						return res * Math.pow(10, nextInt());
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





		public long nextLong() {
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





		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}





		public String next() {
			return nextString();
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}

	private static class OutputWriter {
		private final PrintWriter writer;





		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}





		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}





		public void println(Object... objects) {
			print(objects);
			writer.println();
			writer.flush();
		}





		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0) {
					writer.print(' ');
				}
				writer.print(objects[i]);
			}
			writer.flush();
		}





		public void close() {
			writer.close();
		}





		public void flush() {
			writer.flush();
		}
	}
}