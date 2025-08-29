import java.util.Scanner;

public class Swap_and_Delete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt(); 
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            int count_of_0s = 0;
            int count_of_1s = 0;

           
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0')
                    count_of_0s++;
                else
                    count_of_1s++;
            }

            int length_of_t = 0;

          
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0' && count_of_1s > 0) {
                    count_of_1s--;
                    length_of_t++;
                } else if (s.charAt(i) == '1' && count_of_0s > 0) {
                    count_of_0s--;
                    length_of_t++;
                } else {
                    break;
                }
            }

            System.out.println(n - length_of_t);
        }

        sc.close();
    }
}