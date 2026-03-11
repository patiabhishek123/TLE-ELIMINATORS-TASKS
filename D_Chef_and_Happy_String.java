import java.util.Scanner;

public class D_Chef_and_Happy_String {

   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    
        int t = in.nextInt();
        while (t-- > 0) {
            String s = in.next();
            if (hppy(s)) {
                System.out.println("Happy");
            } else {
                System.out.println("Sad");
            }
        }
        in.close();
    }
    private static boolean hppy(String s) {
        int vol = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
           
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vol++;
            } else {
                vol = 0; 
            }

            
            if (vol > 2) {
                return true;
            }
        }
        return false;
    }
}