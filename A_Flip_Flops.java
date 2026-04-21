import java.util.*;

public class A_Flip_Flops {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-- > 0) {

            int n = in.nextInt();
            long c = in.nextLong();
            long k = in.nextLong();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = in.nextLong();

            Arrays.sort(a);

            int i = 0;

            while (i < n && a[i] <= c) {

                long boost = Math.min(k, c - a[i]);

                a[i] += boost;
                k -= boost;

                c += a[i];

                i++;
            }

            System.out.println(c);
        }

        in.close();
    }
}