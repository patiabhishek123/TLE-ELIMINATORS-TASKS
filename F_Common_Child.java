import java.util.Scanner;

public class F_Common_Child {
    static Integer[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        int n = s1.length();
        dp = new Integer[n][n];

        // System.out.println(solve(s1, s2, n - 1, n - 1));
        System.out.println(bu(s1, s2));
        sc.close();
    }

    // private static int solve(String s1, String s2, int i, int j) {
        
    //     if (i < 0 || j < 0) {
    //         return 0;
    //     }

        
    //     if (dp[i][j] != null) {
    //         return dp[i][j];
    //     }

    //     int result;
    //     if (s1.charAt(i) == s2.charAt(j)) {
            
    //         result = 1 + solve(s1, s2, i - 1, j - 1);
    //     } else {
           
    //         result = Math.max(solve(s1, s2, i - 1, j),
    //                 solve(s1, s2, i, j - 1));
    //     }

        
    //     return dp[i][j] = result;
        
    // }

    public static int bu(String s1, String s2) {
        int n = s1.length();
        
        int[][] dp = new int[2][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + 1;
                } else {
                  
                    dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
                }
            }
        }
        return dp[n % 2][n];
    }
}