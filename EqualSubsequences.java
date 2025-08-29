import java.util.Scanner;

public class EqualSubsequences {

  public static void main(String[] args) {
    Scanner in =new Scanner(System.in);
    int t=in.nextInt();
    while(t-->0)
    {
      int n=in.nextInt();
      int k=in.nextInt();

    StringBuilder sb = new StringBuilder();
    int ones = k, zeros = n - k;
    boolean isOne = true;

// for (int i = 0; i < n; i++) {
//     if (isOne && ones > 0) {
//         sb.append('1');
//         ones--;
//     } else if (!isOne && zeros > 0) {
//         sb.append('0');
//         zeros--;
//     } else if (ones > 0) {
//         sb.append('1');
//         ones--;
//     } else {
//         sb.append('0');
//         zeros--;
//     }
//     isOne = !isOne;
// }
int i;
 for (i = 0; i < k; i++) {
            System.out.print("1");
        }

        // Continue from i = k to n, printing "1"
        for (; i < n; i++) {
            System.out.print("0");
        }

System.out.println();
  }
    }
    
    


}
