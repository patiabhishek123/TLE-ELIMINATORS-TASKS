import java.util.*;

public class LiketheBitset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

          
            boolean impossible = false;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') cnt++;
                else cnt = 0;
                if (cnt >= k) {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                ls.add("NO");
                list.add(null);  
                continue;
            }

            ls.add("YES");

            int[] p = new int[n];
            int high = n, low = 1;

            
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    p[i] = high--;
                }
            }
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    p[i] = low++;
                }
            }

            list.add(p);
        }

        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).equals("NO")) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                int[] x = list.get(i);
                for (int j = 0; j < x.length; j++) {
                    System.out.print(x[j] + (j == x.length - 1 ? "" : " "));
                }
                System.out.println();
            }
        }
    }
}
