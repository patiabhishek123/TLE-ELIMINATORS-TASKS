import java.util.*;

public class Monsters {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int k = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = in.nextInt();
      }

      // List of pairs: (modValue, -index)
      List<int[]> hpIdx = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int mod = arr[i] % k;
        if (mod == 0)
          mod = k; // full multiple of k
        hpIdx.add(new int[] { mod, -i }); // store -i to break ties
      }

      // Sort by mod ascending, then by index descending (because -i)
      hpIdx.sort((a, b) -> {
        if (a[0] != b[0])
          return Integer.compare(a[0], b[0]);
        return Integer.compare(a[1], b[1]); // more negative first = smaller i later
      });

      // Print in reverse order (largest mod first)
      StringBuilder sb = new StringBuilder();
      for (int i = n - 1; i >= 0; i--) {
        int idx = Math.abs(hpIdx.get(i)[1]); // original index
        sb.append(idx + 1).append(" "); // +1 for 1-based indexing
      }
      System.out.println(sb.toString().trim());
    }
  }
}
