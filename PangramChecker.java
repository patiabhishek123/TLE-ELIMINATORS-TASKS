import java.util.Scanner;

public class PangramChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        
        boolean[] l = new boolean[26];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                int idx = c - 'a';
                if (!l[idx]) {
                    l[idx] = true;
                    count++;
                }
            }
        }

        if (count == 26) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
        sc.close();
    }
}