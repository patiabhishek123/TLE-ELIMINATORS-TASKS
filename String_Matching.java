import java.util.Scanner;

public class String_Matching {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.next();
        String ss=new String();
        // applying LPS 

    }
     public static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}