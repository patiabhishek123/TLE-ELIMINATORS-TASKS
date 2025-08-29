
import java.util.*;
import java.io.*;

public class program1 {
  public static void main(String[] args) {
    Scanner in =new Scanner(System.in);
    int t=in.nextInt();
    while(t-->0)
    {
      int l=in.nextInt();
      int[] arr=new int[l];
      for(int i=0;i<l;i++)
       { arr[i]=in.nextInt();}
    Arrays.sort(arr);
   int steps= helper(arr,0,l-1,0);
   System.out.println(steps);
    }
  
     

    
    
  }
  private static int helper(int[] arr,int i,int j,int count)
    {
      boolean x=arr[i]%2==0?true:false;
      boolean y=arr[j]%2==0?true:false;
      if(x==y)return count;
      if(i<0||j>=arr.length)return 0;
       
       int left=helper(arr,i+1,j,count+1);
       int right=helper(arr, i, j-1, count+1);
       return Math.min(left,right);
      
     
    }
    
}
