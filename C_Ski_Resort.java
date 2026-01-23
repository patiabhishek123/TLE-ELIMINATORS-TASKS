// import java.util.Scanner;

// public class C_Ski_Resort {
//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);
//         if (!in.hasNextInt()) return;
//         int t = in.nextInt();

//         while (t-- > 0) {
//             int n = in.nextInt();
//             int k = in.nextInt();
//             int q = in.nextInt();
            
//             long totalWays = 0;
//             long currentSegmentLength = 0;

//             for (int i = 0; i < n; i++) {
//                 int temp = in.nextInt();
                
//                 if (temp <= q) {
//                     // Temperature is valid, increase the length of the current streak
//                     currentSegmentLength++;
//                 } else {
//                     // Temperature is too high, process the segment we just finished
//                     totalWays += calculateWays(currentSegmentLength, k);
//                     currentSegmentLength = 0;
//                 }
//             }
//             // Catch the last segment if the array ended with valid temperatures
//             totalWays += calculateWays(currentSegmentLength, k);
            
//             System.out.println(totalWays);
//         }
//         in.close();
//     }

//     // Helper to calculate combinations for a segment of length 'p'
//     private static long calculateWays(long p, int k) {
//         if (p < k) return 0;
//         long consecutiveOptions = p - k + 1;
//         // Sum of integers from 1 to consecutiveOptions
//         return (consecutiveOptions * (consecutiveOptions + 1)) / 2;
//     }
// }
import java.util.Scanner;

public class C_Ski_Resort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int q = in.nextInt();
            int[] days = new int[n];

            for (int i = 0; i < n; i++)
                days[i] = in.nextInt();

            long sum = 0; // Changed to long to prevent overflow
            int l = 0;    // The start of a potential valid segment

            for (int r = 0; r <= n; r++) {
                // If we reach an invalid day OR the end of the array
                if (r == n || days[r] > q) {
                    long p = r - l; // Length of the current valid segment
                    
                    if (p >= k) {
                        // The number of subsegments of length >= k
                        long m = p - k + 1;
                        sum += (m * (m + 1)) / 2;
                    }
                    l = r + 1; // Move the start pointer past the invalid day
                }
            }
            System.out.println(sum);
        }
        in.close();
    }
}