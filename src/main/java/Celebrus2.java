import java.util.Scanner;

public class Celebrus2 {
	private static final Scanner scanner = new Scanner(System.in);





	public static void main(String[] args) {
		int testCases = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int i = 0; i < testCases; i++) {
			int n = scanner.nextInt();
			int a[] = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = scanner.nextInt();
			}
			System.out.println(maxSubArraySum(a, n));
		}
		scanner.close();
	}





	static int maxSubArraySum(int a[], int size) {
		int max_so_far = a[0];
		int curr_max = a[0];
		for (int i = 1; i < size; i++) {
			curr_max = Math.max(a[i], curr_max + a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}

}
