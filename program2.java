

import java.util.*;

public class program2 {
  public static void main(String[] args) {
    Scanner in=new Scanner (System.in);
    int t=in.nextInt();
    while(t-->0)
    {
      String s=in.next();
      int l=s.length();
      char[] ch=s.toCharArray();
      Stack<Character> stk=new Stack<>();
      int count=0;
      for(char i:ch)
      {
        
        if(i=='(')
        stk.push(i);
        if(i==')')
        stk.pop();
        if(stk.isEmpty())count++;
        
      }
      String ans= count>1?"yes":"no";
      System.out.println(ans);

    }
  }
}
