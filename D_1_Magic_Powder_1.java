import java.util.Scanner;

public class D_1_Magic_Powder_1 {

    private static boolean find(long val, int k, int[] req, int[] av) {
        long totalMagicNeeded = 0; // Use long to prevent overflow
        for (int i = 0; i < req.length; i++) {
            long needed = val * req[i];
            if (needed > av[i]) {
                totalMagicNeeded += (needed - av[i]);
            }
            // Optimization: stop early if we already exceeded k
            if (totalMagicNeeded > k) return false;
        }
        return totalMagicNeeded <= k;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextInt()) return;

        int n = in.nextInt();
        int k = in.nextInt();
        int[] rqt = new int[n];
        int[] av = new int[n];

        for (int i = 0; i < n; i++) rqt[i] = in.nextInt();
        for (int i = 0; i < n; i++) av[i] = in.nextInt();

        long l = 0;
        
        long r = 2000000000L + k; 
        long ans = 0;

        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (find(mid, k, rqt, av)) {
                ans = mid;   
                l = mid + 1;  
            } else {
                r = mid - 1;  
            }
        }
        
        System.out.println(ans);
        in.close();
    }
}