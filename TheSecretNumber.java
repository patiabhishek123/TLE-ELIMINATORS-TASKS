import java.util.*;
public class TheSecretNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            List<Long> results = new ArrayList<>();

            // Try k = 1..18
            for (int k = 1; k <= 18; k++) {
                long d = 1 + (long)Math.pow(10, k);
                if (d > n) break; // no need to check further

                if (n % d == 0) {
                    long x = n / d;
                    if (x > 0) results.add(x);
                }
            }

            if (results.isEmpty()) {
                System.out.println(0);
            } else {
                Collections.sort(results);
                System.out.println(results.size());
                for (int i = 0; i < results.size(); i++) {
                    System.out.print(results.get(i));
                    if (i + 1 < results.size()) System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}
