import java.util.*;

public class HelmetsInNightLight {
    static class Resident {
        int a, b;

        Resident(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int p = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n; i++) b[i] = sc.nextInt();

            List<Resident> residents = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                residents.add(new Resident(a[i], b[i]));
            }

            
            residents.sort(Comparator.comparingInt(r -> r.b));

            int informed = 0;
            long totalCost = 0;

            boolean[] used = new boolean[n];
            int i = 0;

          
            while (informed < n) {
                Resident r = residents.get(i++);
                int toInform = Math.min(r.a, n - informed - 1);
          
                totalCost += p;
                informed++;
      
                totalCost += (long) toInform * r.b;
                informed += toInform;
            }

            System.out.println(totalCost);
        }
    }
}
