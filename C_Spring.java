import java.util.Scanner;

public class C_Spring {

    
    // Compute gcd
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    // Compute lcm safely
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t=sc.nextInt();
        while(t-->0)
        {
            long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long m = sc.nextLong();

       
        long A = m / a;
        long B = m / b;
        long C = m / c;

  
        long ab = lcm(a, b);
        long ac = lcm(a, c);
        long bc = lcm(b, c);

        long AB = m / ab;
        long AC = m / ac;
        long BC = m / bc;

   
        long abc = lcm(ab, c);
        long ABC = m / abc;

    
        long A_only = A - AB - AC + ABC;
        long B_only = B - AB - BC + ABC;
        long C_only = C - AC - BC + ABC;


        long AB_only = AB - ABC;
        long AC_only = AC - ABC;
        long BC_only = BC - ABC;

   
        long waterA =
                6 * A_only +
                3 * (AB_only + AC_only) +
                2 * ABC;

        long waterB =
                6 * B_only +
                3 * (AB_only + BC_only) +
                2 * ABC;

        long waterC =
                6 * C_only +
                3 * (AC_only + BC_only) +
                2 * ABC;

        System.out.println(waterA + " " + waterB + " " + waterC);
        }
    }
}