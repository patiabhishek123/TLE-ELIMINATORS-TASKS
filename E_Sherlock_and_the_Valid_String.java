import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class E_Sherlock_and_the_Valid_String {
public static String isValid(String s) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) {
            f[c - 'a']++;
        }

        
        Map<Integer, Integer> map = new HashMap<>();
        for (int count : f) {
            if (count > 0) {
                map.put(count, map.getOrDefault(count, 0) + 1);
            }
        }

       
        if (map.size() == 1) return "YES";

        
        if (map.size() > 2) return "NO";

        
        List<Integer> freqs = new ArrayList<>(map.keySet());
        int f1 = freqs.get(0);
        int f2 = freqs.get(1);
        
        int count1 = map.get(f1);
        int count2 = map.get(f2);

       
        if ((f1 == 1 && count1 == 1) || (f2 == 1 && count2 == 1)) return "YES";

        
        
        if (Math.abs(f1 - f2) == 1) {
            if ((f1 > f2 && count1 == 1) || (f2 > f1 && count2 == 1)) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String x=in.next();
        System.out.println(isValid(x));
        in.close();
    }
}