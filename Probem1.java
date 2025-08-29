import java.util.*;
public class Probem1
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        int[] arr=new int[3];
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int i=0;
        while(n>0)
        {
            arr[i%3]+=1;
            i++;
            n--;
        }
         System.out.println(arr[0]-arr[2]>=0?arr[0]-arr[2]:arr[2]-arr[0]);;
	}
}
