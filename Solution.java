import java.util.*;

public class Solution {

    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int minimumMoves(List<String> grid,
                                   int startX, int startY,
                                   int goalX, int goalY) {

        int n = grid.size();
        boolean[][] visited = new boolean[n][n];
        int[][] dist = new int[n][n];

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(startX, startY));
        visited[startX][startY] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.r == goalX && cur.c == goalY)
                return dist[cur.r][cur.c];

            
            for (int d = 0; d < 4; d++) {

                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                while (nr >= 0 && nr < n && nc >= 0 && nc < n
                        && grid.get(nr).charAt(nc) != 'X') {

                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        dist[nr][nc] = dist[cur.r][cur.c] + 1;
                        q.add(new Node(nr, nc));
                    }

                    nr += dr[d];
                    nc += dc[d];
                }
            }
        }

        return -1;
    }
}