
import java.util.Scanner;

public class M_Minimum_LCM {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long t = scanner.nextLong(); // Read the number of test cases
		while (t-- > 0) {
			long n = scanner.nextLong(); // Read the integer n for the current test case

			// Initialize ans_a and ans_b with default values
			long ans_a = 1;
			long ans_b = n - 1;

			// Iterate over possible factors of n up to sqrt(n)
			for (long fac = 2; fac * fac <= n; fac++) {
				// Check if fac is a factor of n
				if (n % fac == 0) {
					// If fac is a factor, set ans_a to n / fac
					ans_a = n / fac;
					// Set ans_b to n - ans_a
					ans_b = n - ans_a;
					// Break the loop as we found a valid pair
					break;
				}
			}

			// Output the result for the current test case
			System.out.println(ans_a + " " + ans_b);
		}
		scanner.close();
	}

	// Time Complexity (TC): O(sqrt(10^9)) = O(10^4)
	// Space Complexity (SC): O(1)
}
