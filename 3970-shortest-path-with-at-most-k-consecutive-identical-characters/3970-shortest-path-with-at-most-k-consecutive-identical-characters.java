import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        int m = edges.length;
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] nxt = new int[m], to = new int[m], w = new int[m];
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            to[i] = edges[i][1];
            w[i] = edges[i][2];
            nxt[i] = head[u];
            head[u] = i;
        }

        char[] c = labels.toCharArray();
        int W = k + 1;
        int[] dist = new int[n * W];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Long> pq = new PriorityQueue<>();
        int start = 0 * W + 1;
        dist[start] = 0;
        pq.add((long) start);

        while (!pq.isEmpty()) {
            long top = pq.poll();
            int d = (int) (top >>> 32);
            int state = (int) (top & 0xFFFFFFFFL);
            if (d > dist[state]) continue;

            int u = state / W;
            int run = state % W;
            if (u == n - 1) return d;

            for (int e = head[u]; e != -1; e = nxt[e]) {
                int v = to[e];
                int nr;
                if (c[v] == c[u]) {
                    nr = run + 1;
                    if (nr > k) continue;
                } else {
                    nr = 1;
                }
                int ns = v * W + nr;
                int nd = d + w[e];
                if (nd < dist[ns]) {
                    dist[ns] = nd;
                    pq.add(((long) nd << 32) | ns);
                }
            }
        }
        return -1;
    }
}