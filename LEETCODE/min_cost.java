import java.util.HashMap;

public class min_cost {
public static void main(String[] args) {
    System.out.println(minCost("aabaac",new int[]{1,2,3,4,1,10}));
}
   public static long minCost(String s, int[] cost) {
        char[] chr=s.toCharArray();
        long sum=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(chr[i],map.getOrDefault(chr[i], 0)+cost[i]);
        }
        System.out.println(map);
        for(Integer i : map.values())
        {
            sum+=i;
        }
        System.out.println(sum);

        long min_sum=Long.MAX_VALUE;
        for(Integer i:map.values())
        {
            min_sum=Math.min(min_sum,sum-i);
        }
        return min_sum;
    }
    // static long helper(int[] arr , int relen,int index,long sum){
    //     if(relen!=0 && index==arr.length)
    //         return Long.MAX_VALUE;
    //     else if(relen==0){
    //         return sum;
    //     }
    //     else{
    //         return sum+Math.min(helper(arr, relen-1, index+1, sum+arr[index]),helper(arr, relen, index+1,sum));
    //     }
    // }
    
}