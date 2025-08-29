import java.util.*;

public class Raspberry{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            long ans = Long.MAX_VALUE;
            int evenCount = 0;

            for (int i = 0; i < n; i++) {
                if (a[i] % 2 == 0) {
                    evenCount++;
                }

                if (a[i] % k == 0) {
                    ans = 0;
                } else {
                    ans = Math.min(ans, (k - a[i] % k));
                }
            }

            if (k == 4) {
                if (evenCount >= 2) {
                    ans = Math.min(ans, 0);
                } else if (evenCount == 1) {
                    ans = Math.min(ans, 1);
                } else if (evenCount == 0) {
                    ans = Math.min(ans, 2);
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}