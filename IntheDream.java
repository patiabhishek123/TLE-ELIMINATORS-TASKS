import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// public class IntheDream {
//   public static void main(String[] args) {
    
//     Scanner in=new Scanner(System.in);
//     List<String> list=new ArrayList<>();
//     int t=in.nextInt();
//     while(t-->0)
//     {
//       int R=in.nextInt();
//       int K=in.nextInt();
//       R+=in.nextInt();
//       K=in.nextInt();
//        while(R>0&&K>0)
//     {
//       if(R<3)
//       {
//         if(K<3)
//         {
//           list.add("YES");
//           break;
//         }
//         else
//         {
//          list.add("NO");
//           break;
//         }
//       }
//         else
//        {
//         if(K<3)
//         {
//           list.add("NO");
//           break;
//         }
//         else
//         {
//           K--;
//           R--;
//         }
//       }

    
//     }
//     }
//    for(String x:list)
//    System.out.println(x);
//   }
// }
import java.util.Scanner;

public class IntheDream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list=new ArrayList<>();
        int t = sc.nextInt();   // number of test cases

        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            // First half scores
            boolean ok1 = isValidHalf(a, b);

            // Second half additional scores
            int ra = c - a;
            int rb = d - b;
            boolean ok2 = isValidHalf(ra, rb);

            if (ok1 && ok2) {
                list.add("YES");
            } else {
                 list.add("NO");
            }
        }
          for(String x:list)
            System.out.println(x);

        sc.close();
    }

    // Check if it's possible to arrange scores x, y without 3 consecutive goals
    private static boolean isValidHalf(int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        return max <= 2 * (min + 1);
    }
}
