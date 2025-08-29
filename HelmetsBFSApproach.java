import java.util.*;

public class HelmetsBFSApproach {
    static class Resident {
        int a, b;
        public Resident(int a, int b) {
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

          
            PriorityQueue<Resident> pq = new PriorityQueue<>(Comparator.comparingInt(r -> r.b));
            for (int i = 0; i < n; i++) pq.offer(new Resident(a[i], b[i]));

            int informed = 0;
            long totalCost = 0;

            Queue<Resident> bfsQueue = new LinkedList<>();

            while (informed < n) {
                
                if (bfsQueue.isEmpty()) {
                    
                    Resident r = pq.poll();
                    totalCost += p;
                    informed++;
                    bfsQueue.offer(r);
                } else {
                    Resident spreader = bfsQueue.poll();
                    int canShare = Math.min(spreader.a, n - informed);
                    totalCost += (long) canShare * spreader.b;
                    informed += canShare;

                    
                    for (int i = 0; i < canShare && !pq.isEmpty(); i++) {
                        bfsQueue.offer(pq.poll());
                    }
                }
            }

            System.out.println(totalCost);
        }
    }
}
