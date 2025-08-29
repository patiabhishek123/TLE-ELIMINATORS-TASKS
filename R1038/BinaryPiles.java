import java.util.*;

public class BinaryPiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        List<Long> list=new ArrayList<>();
        for (int test = 0; test < t; test++) {
            int n = sc.nextInt(); 

            long zeroIn = 0, zeroOut = 0;
            long oneIn = 0, oneOut = 0;

            for (int i = 0; i < n; i++) {
                long a = sc.nextLong();
                long b = sc.nextLong();
                long c = sc.nextLong();
                long d = sc.nextLong();

                if (c > a) {
                   if(d==0) zeroIn += c - a;
                   else  zeroIn += c - a+1;
                } else {
                   if(b==0) zeroOut += a - c;
                   else  zeroOut += a - c+1;
                }

                if (d > b) {
                   if(c==0) oneIn += d - b;
                   else  oneIn += d - b+1;
                } else {
                    if(a==0)oneOut += b - d;
                    else oneOut += b - d+1;
                }
            }

            long ans = Math.max(zeroIn, zeroOut) + Math.max(oneIn, oneOut);
          list.add(ans);
        }
        for(long x:list)
        System.out.println(x);

        sc.close();
    }
}
