import java.util.*;

public class Homework {
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int t=in.nextInt();
    List<StringBuffer> ans=new ArrayList<>();
    while(t-->0)
    {
      int n=in.nextInt();
      String a=in.next();
      int m=in.nextInt();
      String b=in.next();
      String c=in.next();
      StringBuffer aa=new StringBuffer(a);
      char[] chr=c.toCharArray();
      for(int i=0;i<chr.length;i++)
      {
        if(chr[i]=='V')
        aa.insert(0, b.charAt(i));
        else
        aa.append(b.charAt(i));
      }
     ans.add(aa);
      
    }
    for(StringBuffer x:ans)
    {
      System.out.println(x.toString());
    }
  }
}
