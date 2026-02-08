import java.util.*;

public class A_DBMB_and_the_Array{
public static void main(String[] args) {
    Scanner in =new Scanner(System.in);
    int t = in.nextInt();
    while(t-->0){
        int n=in.nextInt();
        int s=in.nextInt();
        int x=in.nextInt();
        int sum=0;

        for(int i=0;i<n;i++){
            sum+=in.nextInt();
        }
        if((s-sum)<0||(s-sum)%x!=0)
        {
            System.out.println("NO");
        }
        else
            System.out.println("YES");
    }
    in.close();
}
}