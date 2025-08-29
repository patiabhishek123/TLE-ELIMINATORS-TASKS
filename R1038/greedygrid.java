import java.util.*;
public class greedygrid {
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int t=in.nextInt();
    while(t-->0)
    {
      int n=in.nextInt()-1;
      int m=in.nextInt()-1;
      if((n==1||m==1)||(n==2&&m==2))
      System.out.println("No");
      else
      System.out.println("YES");
    }

  }
}
