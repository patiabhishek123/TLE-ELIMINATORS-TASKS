import java.util.*;;


public class A_Table_with_Numbers {

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int t= in.nextInt();
        Set<Integer> ls=new HashSet<>();
        Set<Integer> hs=new HashSet<>();

        int n=in.nextInt();
        int l = in.nextInt();
        int h = in.nextInt();

        if(l>h)
        {
            int p=l;
            l=h;
            h=p;
        }
        for( int i=0;i<n;i++)
        {
            int x =in.nextInt();
            if(x<=l)
                ls.add(x);
            else if (x<=h) {
                hs.add(x);
            }
        }
        int ans=0;
        int ls_size=ls.size();
        int hs_size=hs.size();

        if(ls_size>hs_size)
        {
            ans+=hs_size;
            ls_size-=hs_size;
            ans+=ls_size/2;
        }
        else if (ls_size==hs_size) {
            ans+=ls_size;
        }
        else
        {
            ans+=ls_size;
        }
            
    }
}