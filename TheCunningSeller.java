import java.util.*;

public class TheCunningSeller {
    static long cost(int x) {
        if (x == 0) return 3;
        return (long) Math.pow(3, x + 1) + (long) x * (long) Math.pow(3, x - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

       
        List<Integer> amounts = new ArrayList<>();
        List<Long> costs = new ArrayList<>();
        for (int x = 0; ; x++) {
            long amount = (long) Math.pow(3, x);
            if (amount > 1e9) break;
            amounts.add((int) amount);
            costs.add(cost(x));
        }

        while (t-- > 0) {
            long n = in.nextLong();
            long ans = 0;

            
            for (int i = amounts.size() - 1; i >= 0; i--) {
                while (n >= amounts.get(i)) {
                    n -= amounts.get(i);
                    ans += costs.get(i);
                }
            }
            System.out.println(ans);
        }
    }
}
