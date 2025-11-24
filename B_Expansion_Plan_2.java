import java.io.*;
import java.util.*;

public class B_Expansion_Plan_2 {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        long t = fs.nextLong();
        while (t-- > 0) {

            long n = fs.nextLong();
            long x = fs.nextLong();
            long y = fs.nextLong();

            String s = fs.next();

            long a = 0, b = 0;

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '4') a++;
                if (c == '8') b++;
            }

            x = Math.abs(x);
            y = Math.abs(y);

            if (a + 2L * b < x + y) out.append("NO\n");
            else if (a + b < Math.max(x, y)) out.append("NO\n");
            else out.append("YES\n");
        }

        System.out.print(out.toString());
    }

    // ---------- FAST INPUT READER ----------
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            long val = 0;
            int c = read();
            boolean neg = false;

            while (c <= ' ') c = read();
            if (c == '-') {
                neg = true;
                c = read();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }

            return neg ? -val : val;
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c = read();
            while (c <= ' ') c = read();
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }
    }
}
