import java.util.*;
public class vj1{
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int t=in.nextInt();
    while(t-->0)
    {
      int a=in.nextInt();int  b=in.nextInt();int c=in.nextInt();
      System.out.println(a+b==c||a+c==b||b+c==a?"YES":"NO");
    }
    
  }
}