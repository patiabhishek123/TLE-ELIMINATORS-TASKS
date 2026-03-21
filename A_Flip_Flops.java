import java.util.Scanner;

public class A_Flip_Flops {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while (t-->0) {
            int n=in.nextInt();
            long c=in.nextLong();
            long k=in.nextLong();
            long[] arr=new long[n];
            
            //array filled
            for(int i=0;i<n;i++)
            {
                arr[i]=in.nextLong();
            }

            //finding the index that is leftbound of c;
            long p=0;
            while((p=bs(c,arr))<=c)
            {
                if(p-c<=k)
                {
                    c+=(p-c);
                    k-=(p-c);
                }
                c+=p;
            }
            System.out.println(c);

        }
        in.close();
       
    }
     private static long bs(long c ,long[] arr)
        {
            int l=-1,r=arr.length;
            while (l<=r-1) {
                int m=(l+r)/2;
                if(arr[m]<c)
                    r=m;
                else
                    l=r;
            }
            return arr[r];
        }

    
}