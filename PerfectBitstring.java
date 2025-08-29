import java.util.*;

public class PerfectBitstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            StringBuilder sb = new StringBuilder();

            // Case 1: All 1s or all 0s
            if (k == 0) {
                for (int i = 0; i < n; i++)
                    sb.append('0');
            } else if (k == n) {
                for (int i = 0; i < n; i++)
                    sb.append('1');
            } else {
                // Alternate to balance 101 and 010
                int onesLeft = k;
                int zerosLeft = n - k;

                for (int i = 0; i < n; i++) {
                    if ((i % 2 == 0 && onesLeft > 0) || zerosLeft == 0) {
                        sb.append('1');
                        onesLeft--;
                    } else {
                        sb.append('0');
                        zerosLeft--;
                    }
                }
            }

            System.out.println(sb.toString());
        }
    }
}
