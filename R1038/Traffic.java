import java.io.*;
import java.util.*;

public class Traffic{
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            // --- 1) Read graph in input order
            ArrayList<Integer>[] adj = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                // add edges in order
                adj[u].add(v);
                adj[v].add(u);
            }

            // --- 2) Prepare per-(node,phase) state
            // phase = t mod deg(u)
            int[] deg = new int[n+1];
            for (int u = 1; u <= n; u++) {
                deg[u] = adj[u].size();
            }

            // visited[u][phase], waitCnt[u][phase]
            boolean[][] visited = new boolean[n+1][];
            int[][] waitCnt  = new int[n+1][];
            for (int u = 1; u <= n; u++) {
                visited[u] = new boolean[deg[u]];
                waitCnt [u] = new int[deg[u]];
            }

            // --- 3) BFS by layers (time), tracking two queues: moves first, then waits
            // current layer of states
            ArrayList<int[]> curr = new ArrayList<>();
            // next-layer queues
            ArrayList<int[]> nextMoves = new ArrayList<>();
            ArrayList<int[]> nextWaits = new ArrayList<>();

            // start at (1, phase=0), time=0, waits=0
            visited[1][0] = true;
            waitCnt[1][0] = 0;
            curr.add(new int[]{1, 0});

            int time = 0;
            boolean done = false;
            int bestWait = Integer.MAX_VALUE;
            int bestTime = -1;

            while (!curr.isEmpty() && !done) {
                nextMoves.clear();
                nextWaits.clear();

                // for collecting waits at vertex n in this next layer
                int layerMinWait = Integer.MAX_VALUE;
                boolean reachedN = false;

                // process entire layer at time 'time'
                for (int[] st : curr) {
                    int u     = st[0];
                    int phase = st[1];
                    int w     = waitCnt[u][phase];

                    // 1) MOVE along the (phase)-th edge of u
                    //    new time = time+1, wait stays w
                    if (deg[u] > 0) {
                        int v = adj[u].get(phase);
                        int newPhase = (time + 1) % deg[v];
                        if (!visited[v][newPhase]) {
                            visited[v][newPhase] = true;
                            waitCnt[v][newPhase] = w;
                            if (v == n) {
                                reachedN = true;
                                layerMinWait = Math.min(layerMinWait, w);
                            }
                            nextMoves.add(new int[]{v, newPhase});
                        }
                    }

                    // 2) WAIT at u
                    //    new time = time+1, wait = w+1
                    if (deg[u] > 0) {
                        int newPhase = (phase + 1) % deg[u];
                        if (!visited[u][newPhase]) {
                            visited[u][newPhase] = true;
                            waitCnt[u][newPhase] = w + 1;
                            if (u == n) {
                                reachedN = true;
                                layerMinWait = Math.min(layerMinWait, w + 1);
                            }
                            nextWaits.add(new int[]{u, newPhase});
                        }
                    }
                }

                // if we reached n in the next time layer:
                if (reachedN) {
                    bestTime = time + 1;
                    bestWait = layerMinWait;
                    done = true;
                    break;
                }

                // otherwise move on to next layer
                time++;
                curr.clear();
                // enqueue moves *first*, then waits
                curr.addAll(nextMoves);
                curr.addAll(nextWaits);
            }

            // print answer
            out.println(bestTime + " " + bestWait);
        }

        out.flush();
    }
}
