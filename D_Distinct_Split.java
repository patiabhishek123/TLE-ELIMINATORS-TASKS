import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class D_Distinct_Split {

  public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t-- > 0) {
			int n = scanner.nextInt(); 
			String s = scanner.next(); 

			Set<Character> st = new HashSet<>(); 
			long[] prefixUniqueCount = new long[n + 1];
			long[] suffixUniqueCount = new long[n + 1]; 

			
			for (int i = 1; i <= n; i++) {
				st.add(s.charAt(i - 1)); 
				prefixUniqueCount[i] = st.size(); 
			}

			st.clear();

			
			for (int i = n; i >= 1; i--) {
				st.add(s.charAt(i - 1)); 
				suffixUniqueCount[i] = st.size(); 
			}

			long ans = 0; 
			
			for (int i = 0; i < n; i++) {
				ans = Math.max(ans, prefixUniqueCount[i] + suffixUniqueCount[i + 1]); 
			}
			System.out.println(ans); // Output the result for the current test case
		}
		scanner.close();
	}
}