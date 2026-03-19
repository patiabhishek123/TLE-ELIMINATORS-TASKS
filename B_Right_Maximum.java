import java.util.*;

public class B_Right_Maximum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int max = 0;
            int operations = 0;

            for (int i = 0; i < n; i++) {
                int x = in.nextInt();

                if (x >= max) {
                    operations++;
                    max = x;
                }
            }

            System.out.println(operations);
        }

        in.close();
    }
}