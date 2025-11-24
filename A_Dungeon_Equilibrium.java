import java.util.*;
public class A_Dungeon_Equilibrium {
    public static void main(String[] args) {
       Scanner in =new Scanner(System.in);
         int M=in.nextInt();
         while(M-->0)
         {
            int n=in.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
            {
               arr[i]=in.nextInt();
            }
            HashMap<Integer,Integer>map=new HashMap<>();
            for(int i :arr)
            {
               map.put(i,map.getOrDefault(i,0)+1);
            }
            int sum=0;
            for(Map.Entry<Integer,Integer> entry:map.entrySet())
            {
               if(entry.getKey()<=entry.getValue())
               sum+=(entry.getValue()-entry.getKey());
               else
               sum+=(entry.getValue());
            }
              System.out.println(sum);
         }

       }
          
}