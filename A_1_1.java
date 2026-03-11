// import java.util.Scanner;

// public class A_1_1 {

//     public static void main(String[] args) {
//         Scanner in=new Scanner(System.in);
//         int t=in.nextInt();
//         while (t-->0) {
//             int n=in.nextInt();
//             String str=in.next();

//             // 0's
//             int zb=0;int znb=0;int ob=0;int onb=0;int z=0;int o=0;
//             for(char ch: str.toCharArray())
//             {
//                 if(ch=='1')o++;
//                 else z++;
//             }
//             for(int i=1;i<n-1;i++)
//             {
//                 if(str.charAt(i)=='1'&&str.charAt(i-1)=='1'&&str.charAt(i+1)=='1' )
//                     ob++;
//                 else if(str.charAt(i)=='0'&&str.charAt(i-1)=='1' &&str.charAt(i+1)=='1' )
//                     zb++;
//                 else{
//                     znb+=str.charAt(i)=='0'?1:0;
//                     onb+=str.charAt(i)=='1'?1:0;
//                 }
//             }
//             System.out.print(o-ob+" ");
//             System.out.println(o+zb);
            
//         }
//         in.close();
//     }
// }
import java.util.Scanner;

public class  A_1_1  {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();
            
            // Convert to char arrays for simulation
            char[] maxArr = s.toCharArray();
            char[] minArr = s.toCharArray();

            // MAX Simulation: Flip 0 -> 1 if surrounded by 1s
            // Repeat until no more flips possible (Chain reaction)
            boolean changed = true;
            while (changed) {
                changed = false;
                for (int i = 1; i < n - 1; i++) {
                    if (maxArr[i] == '0' && maxArr[i-1] == '1' && maxArr[i+1] == '1') {
                        maxArr[i] = '1';
                        changed = true;
                    }
                }
            }

            char[] tempMin = maxArr.clone(); 
            for (int i = 1; i < n - 1; i++) {
                if (tempMin[i] == '1' && tempMin[i-1] == '1' && tempMin[i+1] == '1') {
                    tempMin[i] = '0';
                }
            }

           
            int maxCount = 0, minCount = 0;
            for (int i = 0; i < n; i++) {
                if (maxArr[i] == '1') maxCount++;
                if (tempMin[i] == '1') minCount++;
            }

            System.out.println(minCount + " " + maxCount);
        }
        in.close();
    }
}