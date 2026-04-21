import java.util.Scanner;

public class B_Vika_and_the_Bridge {
    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int[] color= new int[n];
        for(int i=0;i<n;i++)
        {
            color[i]=in.nextInt();
        }
        int min=Integer.MAX_VALUE;
        while(k>0)
        {
            int f=-1;
            for( int i=0;i<n;i++)
            {
                if(color[i]==k)
                {
                    f=i;
                    break;
                }
            }

            for(int i=n-1;i>=0;i--)
            {
                if(color[]==k)
                {
                    l=i;
                    break;
                }
            }
            int fi=f;

            while (color[fi]>) {
                
            }
        }
    }
}
