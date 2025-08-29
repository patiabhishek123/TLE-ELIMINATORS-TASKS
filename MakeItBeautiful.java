import java.util.*;

public class MakeItBeautiful {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      long k = in.nextLong();

      long[] arr = new long[n];
      for (int i = 0; i < n; i++) {
        arr[i] = in.nextLong();

      }
      Arrays.sort(arr);
      int count = 0;
      for (int i = 0; i < n; i++) {
        int sb = setbit(arr[i]);
        count += sb;
        if (k > 0 && arr[i] % 2 == 0) {
          count += 1;
          k--;
        }
      }
      System.out.println(count);

    }
  }

  static int setbit(long x) {
    int count = 0;
    while (x > 0) {
      x &= (x - 1);
      count++;
    }
    return count;
  }
}
