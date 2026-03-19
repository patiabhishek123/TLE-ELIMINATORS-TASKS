import java.util.Scanner;

public class A_Passing_the_Ball {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while (t-->0) {
            int n=in.nextInt();
            String str=in.next();
            int count=0;
            for(char ch :str.toCharArray() )
            {
               
                if(ch=='L')
                {
                    count++;
                    break;
                }
                 count++;
            }
            System.out.println(count);
        }
        in.close();
    }
}