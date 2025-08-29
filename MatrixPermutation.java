// import java.util.*;

// public class Make_It_Permutation {
//   public static void main(String[] args) {
//     Scanner in=new Scanner(System.in);
//     int t=in.nextInt();
//     while(t-->0)
//     {
//       int n=in.nextInt();
//       int count;
//       int[][] arr=new int[n][n];
//       for(int i=0;i<n;i++)
//       { 
//         count=1;
//         for(int j=0;j<n;j++)
//         {
//             arr[i][j]=(i+count)%n==0?n:(i+count)%n;
//             count++;
//         }
//       }
//         for(int i=0;i<n;i++)
//       {
//         for(int j=0;j<n;j++)
//         {
//            System.out.print(arr[i][j]);
//           }
//           System.out.println();
//       }
    


//     }
//   }
// }
import java.util.*;

public class MatrixPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();
            List<String> ops = new ArrayList<>();

            for (int i = 2; i <= n; i++) {
                // Reverse row i from column 1 to i
                ops.add(i + " 1 " + i);
            }

            // Output number of operations
            System.out.println(ops.size());

            // Output the operations
            for (String op : ops) {
                System.out.println(op);
            }
        }
    }
}

