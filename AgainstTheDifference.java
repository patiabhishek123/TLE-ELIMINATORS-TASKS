
import java.util.*;

public class AgainstTheDifference{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        int t = sc.nextInt();
        // while (t-- > 0) {
        //     int n = sc.nextInt();
        //     int[] a = new int[n];
        //     for (int i = 0; i < n; i++) {
        //         a[i] = sc.nextInt();
        //     }

        //     int[] freq = new int[n + 1]; // since ai ≤ n
        //     for (int x : a) {
        //         freq[x]++;
        //     }

        //     int ans = 0;
        //     for (int v = 1; v <= n; v++) {
        //         ans += (freq[v] / v) * v;
        //     }

        //    list.add(ans);
        // }
        while(t-->0) {
            int n = sc.nextInt();   // size of array
            int[] arr = new int[n];
            
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            int groups = 1;  // at least one group will exist
            for(int i = 1; i < n; i++) {
                if(arr[i] != arr[i-1]) {
                    groups++;
                }
            }
            
            list.add(groups);
        }
        for(int i:list)
         System.out.println(i);
         sc.close();
    }
}

