import java.util.*;

public class MaxManhattanPairs {
    static class Point {
        int x, y, idx;
        Point(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Point[] points = new Point[n];
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                points[i] = new Point(x, y, i + 1);
            }

            Arrays.sort(points, (a, b) -> a.x - b.x);

            for (int i = 0; i < n / 2; i++) {
                int a = points[i].idx;
                int b = points[n - 1 - i].idx;
                System.out.println(a + " " + b);
            }
        }

        sc.close();
    }
}
