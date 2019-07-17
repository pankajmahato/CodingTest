import java.io.BufferedReader;
import java.io.InputStreamReader;


/*
 * Fishes & Ducks
A forest has N ducks, waiting to be fed, but the age of each duck can be different or same as other ducks. Mommy duck has to feed the ducks with the following requirements:

Every duck should get at least one fish.
A duck with higher age standing next to the neighboring ducks should get more fish.
How should mommy duck allocate such that total number of fishes is minimized?

Example #1
Age of the ducks: [2, 0, 1]

How?: You can give 1 fish to the duck in the middle and 2 to the ducks at each end.

Allocation [2, 1, 2]

Example #2
Age of the ducks: [1, 2, 3]

Explanation: You can allocate 1 fish to the first duck, 2 to the second duck and 3 to the third duck.

Allocation: [1, 2, 3]

Example #3
Age of the ducks: [1, 5, 5, 5, 1]

Allocation: [1, 2, 1, 2, 1]

Input Format
First line contains single integer T denoting the number of test cases. T test cases follow.
Each test case contains two lines. The first line is the number of ducks N to be fed. The second line is the space separated ages of the ducks.

Output Format
For each test case, in a single line print the space separated allocation of fishes.

Constraints
1 ≤ T (number of test cases) ≤ 5

1 ≤ N (number of ducks) ≤ 10^5

0 ≤ A (age of each duck) ≤ 5

Environment
Read from STDIN and write to STDOUT.

See sample programs below which read two numbers from STDIN and write their sum to STDOUT.

Java https://goo.gl/QUZhgb (class name “solution”, no package declarations)
Python3 https://goo.gl/myYeoA
Ruby https://goo.gl/PhpUyX
The dashboard provides two modes.

Test runs your code against sample test cases. Submit runs against hidden ones.

Only sample test cases and their elaborate “test” results are made available. We also show a line by line comparison with expected output. There is no score for passing the sample test cases. It’s only for testing and debugging.

For the private test cases, the judging system only shows the exit code, passed status, time consumption, memory consumption and score. We expect users to take cues from these values. Only making a “submit” will yield a score.


SAMPLE STDIN 1

5
11
2 0 1 1 2 3 1 5 5 5 1
1
4
2
2 1
35
1 5 5 5 5 1 0 0 3 1 0 0 0 0 1 1 0 1 1 0 1 2 0 4 4 0 0 5 0 5 0 3 2 0 0
29
5 4 3 0 1 3 2 2 3 1 5 2 5 5 5 5 3 1 1 1 0 4 5 0 5 2 3 4 2
SAMPLE STDOUT 1

2 1 2 1 2 3 1 2 1 2 1
1
2 1
1 2 1 1 3 2 1 1 3 2 1 1 1 1 2 2 1 2 2 1 2 3 1 2 2 1 1 2 1 2 1 3 2 1 1
4 3 2 1 2 3 1 1 2 1 2 1 2 1 1 3 2 1 1 2 1 2 3 1 2 1 2 3 1


  


 *
 */

public class MoEngage {

	public static void main(String[] args) {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int testcases;
		try {
			testcases = Integer.parseInt(scan.readLine());
			for (int t = 0; t < testcases; t++) {
				int length = Integer.parseInt(scan.readLine());
				String[] data = scan.readLine().split(" ");
				feedFish(data);
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}





	private static void feedFish(String[] data) {
		int[] output = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			int count = 1;
			int k = i;
			int leftCount = 1;
			if (i > 0 && Integer.parseInt(data[i]) > Integer.parseInt(data[i - 1])) {
				leftCount = output[i - 1] + 1;
			}

			for (int j = i + 1; j < data.length; j++) {
				int now = Integer.parseInt(data[k]);
				int next = Integer.parseInt(data[j]);
				if (now > next) {
					k++;
					count++;
				} else {
					break;
				}
			}
			output[i] = count > leftCount ? count : leftCount;
		}
		for (int i : output) {
			System.out.print(i + " ");
		}
	}
}
