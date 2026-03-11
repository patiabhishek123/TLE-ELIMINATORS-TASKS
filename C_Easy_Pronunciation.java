import java.util.Scanner;

public class C_Easy_Pronunciation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();
            
            int count = 0;
            boolean isHard = false;

            for (int i = 0; i < n; i++) {
                if (isVowel(s.charAt(i))) {
                    count = 0; 
                } else {
                    count++; 
                }

                if (count >= 4) {
                    isHard = true;
                    break;
                }
            }
            System.out.println(isHard ? "NO" : "YES");
        }
        in.close();
    }

    
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}