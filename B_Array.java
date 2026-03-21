import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B_Array {

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int t = sc.nextInt();

    //     while (t-- > 0) {
    //         int n = sc.nextInt();
    //         long[] a = new long[n];

    //         for (int i = 0; i < n; i++) a[i] = sc.nextLong();

    //         int[] ans = new int[n];

    //         for (int i = 0; i < n; i++) {

    //             ArrayList<Double> left = new ArrayList<>();
    //             ArrayList<Double> right = new ArrayList<>();

    //             for (int j = i + 1; j < n; j++) {

    //                 double mid = (a[i] + a[j]) / 2.0;

    //                 if (a[j] < a[i]) left.add(mid);
    //                 else if (a[j] > a[i]) right.add(mid);
    //             }

    //             Collections.sort(left);
    //             Collections.sort(right);

    //             int best = 0;

              
    //             best = Math.max(best, left.size());

           
    //             best = Math.max(best, right.size());

    //             for (double k : left) {

    //                 int countLeft = left.size() - upperBound(left, k);
    //                 int countRight = lowerBound(right, k);

    //                 best = Math.max(best, countLeft + countRight);
    //             }

    //             for (double k : right) {

    //                 int countLeft = left.size() - upperBound(left, k);
    //                 int countRight = lowerBound(right, k);

    //                 best = Math.max(best, countLeft + countRight);
    //             }

    //             ans[i] = best;
    //         }

    //         for (int x : ans) System.out.print(x + " ");
    //         System.out.println();
    //     }
    // }

    // static int lowerBound(List<Double> arr, double x) {
    //     int l = 0, r = arr.size();
    //     while (l < r) {
    //         int m = (l + r) / 2;
    //         if (arr.get(m) < x) l = m + 1;
    //         else r = m;
    //     }
    //     return l;
    // }

    // static int upperBound(List<Double> arr, double x) {
    //     int l = 0, r = arr.size();
    //     while (l < r) {
    //         int m = (l + r) / 2;
    //         if (arr.get(m) <= x) l = m + 1;
    //         else r = m;
    //     }
    //     return l;
    // }

    //  static class Node implements Comparable<Node> {
    //     double m;
    //     int type; // +1 for RIGHT, -1 for LEFT

    //     Node(double m, int type) {
    //         this.m = m;
    //         this.type = type;
    //     }

    //     public int compareTo(Node o) {
    //         return Double.compare(this.m, o.m);
    //     }
    // }

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int t = sc.nextInt();

    //     while (t-- > 0) {
    //         int n = sc.nextInt();
    //         long[] a = new long[n];
    //         for (int i = 0; i < n; i++) a[i] = sc.nextLong();

    //         int[] ans = new int[n];

    //         for (int i = 0; i < n; i++) {

    //             List<Node> list = new ArrayList<>();
    //             int cur = 0;

    //             for (int j = i + 1; j < n; j++) {
    //                 if (a[j] == a[i]) continue;

    //                 double m = (a[i] + a[j]) / 2.0;

    //                 if (a[j] > a[i]) {
    //                     // contributes for k > m
    //                     list.add(new Node(m, +1));
    //                 } else {
    //                     // contributes for k < m
    //                     list.add(new Node(m, -1));
    //                     cur++; // active at k = -∞
    //                 }
    //             }

    //             Collections.sort(list);

    //             int best = cur;

    //             for (Node nd : list) {
    //                 if (nd.type == -1) cur--; // left stops
    //                 else cur++;               // right starts
    //                 best = Math.max(best, cur);
    //             }

    //             ans[i] = best;
    //         }

    //         for (int i = 0; i < n; i++) {
    //             if (i > 0) System.out.print(" ");
    //             System.out.print(ans[i]);
    //         }
    //         System.out.println();
    //     }
    // }

    static FastScanner fs = new FastScanner(System.in);

    public static void main(String[] args) throws Exception {
        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = fs.nextLong();

            int[] ans = new int[n];

            for (int i = 0; i < n; i++) {

                int rsz = 0, lsz = 0;

                long[] right = new long[n];
                long[] left = new long[n];

                for (int j = i + 1; j < n; j++) {
                    if (a[j] > a[i]) right[rsz++] = a[j];
                    else if (a[j] < a[i]) left[lsz++] = a[j];
                }

                Arrays.sort(right, 0, rsz);          // ascending
                Arrays.sort(left, 0, lsz);           // ascending

                int cur = lsz;   // k = -∞ → all left count
                int best = cur;

                int lp = 0, rp = 0;

                while (lp < lsz || rp < rsz) {

                    long nextLeft = (lp < lsz) ? left[lp] : Long.MAX_VALUE;
                    long nextRight = (rp < rsz) ? right[rp] : Long.MAX_VALUE;

                    // Compare midpoints using integers:
                    // midpoint(ai, x) = (ai + x)/2
                    // smaller midpoint processed first

                    if (lp < lsz &&
                       (rp == rsz ||
                        a[i] + nextLeft <= a[i] + nextRight)) {

                        // left stops contributing
                        cur--;
                        lp++;

                    } else {
                        // right starts contributing
                        cur++;
                        rp++;
                    }

                    if (cur > best) best = cur;
                }

                ans[i] = best;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i > 0) sb.append(' ');
                sb.append(ans[i]);
            }
            System.out.println(sb);
        }
    }

             
    static class FastScanner {
        BufferedInputStream in;
        byte[] buffer = new byte[1 << 16];
        int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = new BufferedInputStream(is);
        }

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') ;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = c - '0';
            while ((c = read()) > ' ')
                val = val * 10 + c - '0';
            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}