import java.util.Arrays;
import java.util.Scanner;

// public class B_Interesting_drink {
//     public static void main(String[] args) {
//         Scanner in=new Scanner(System.in);
//         long n=in.nextLong();
//         long[] price=new long[(int)n];
//         Arrays.sort(price);
//         for(int i=0;i<n;i++)
//         {
//             price[i]=in.nextLong();
//         }
//         long q=in.nextLong();
//         for(long i=1;i<=q;i++)
//         {
//             long k=in.nextLong();
//             long l=-1;
//             long r=n;
//             long  m;
            
//             //upperbound of the prices arr such that prices[i]<k
//             //answer is upperbound 
//             while(r-l>1)
//             {
//                 m=l+(r-l)/2;
//                 if(price[(int)m]>k)
//                     r=m;
//                 else
//                     l=m;
//             }
//             if(r<=n)
//                 System.out.println(l+1);
//             else
//                 System.out.println(0);
//         }
//         in.close();
        
//     }
    
// }
import java.util.*;

public class B_Interesting_drink {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[] price = new long[n];

        for (int i = 0; i < n; i++) {
            price[i] = in.nextLong();
        }

        Arrays.sort(price);  // IMPORTANT

        int q = in.nextInt();

        while (q-- > 0) {
            long k = in.nextLong();

            int l = -1, r = n;

            while (r - l > 1) {
                int m = l + (r - l) / 2;

                if (price[m] <= k)
                    l = m;
                else
                    r = m;
            }

            System.out.println(l + 1); // count of ≤ k
        }

        in.close();
    }
}