import java.util.*;

public class B_Olya_and_Game_with_Arrays {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long t = scanner.nextLong(); // Read the number of test cases
		while (t-- > 0) {
			long n = scanner.nextLong(); // Read the number of arrays in the current test case

			List<Long> secondElements = new ArrayList<>(); // List to store the second smallest elements of each array
			long lowestFirstMinimum = Long.MAX_VALUE; // Variable to track the smallest of the first minimums

			for (int i = 0; i < n; i++) { // Iterate over each array
				long m = scanner.nextLong(); // Read the number of elements in the current array
				long[] a = new long[(int) m]; // Array to store elements of the current array
				for (int j = 0; j < m; j++) { // Read elements of the array
					a[j] = scanner.nextLong();
				}

				Arrays.sort(a); // Sort the array to find the smallest elements

				secondElements.add(a[1]); // Store the second smallest element
				lowestFirstMinimum = Math.min(lowestFirstMinimum, a[0]); // Update the smallest of the first minimums
			}

			Collections.sort(secondElements); // Sort the second smallest elements

			long sumOfSecondElements = 0;
			for (long element : secondElements) {
				sumOfSecondElements += element; // Calculate the sum of second smallest elements
			}
			long lowestSecondMinimum = secondElements.get(0); // Find the smallest of the second smallest elements

			long answer = lowestFirstMinimum + sumOfSecondElements - lowestSecondMinimum; // Calculate the maximum beauty
			System.out.println(answer); // Output the result for the current test case
		}
		scanner.close();
	}
}
