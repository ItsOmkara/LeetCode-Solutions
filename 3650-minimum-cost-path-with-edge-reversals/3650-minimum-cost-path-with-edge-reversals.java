class Solution {
    public int minCost(int n, int[][] edges) {
        List<int[]>[] graph = new List[n];
        List<int[]>[] incoming = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            incoming[i] = new ArrayList<>();
        }
        
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph[u].add(new int[]{v, w});
            incoming[v].add(new int[]{u, w}); 
        }
        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) {
            dist[i][0] = Integer.MAX_VALUE;
            dist[i][1] = Integer.MAX_VALUE;
        }
        dist[0][0] = 0;
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); 
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], u = curr[1], used = curr[2];
            
            if (cost > dist[u][used]) continue;
            for (int[] edge : graph[u]) {
                int v = edge[0], w = edge[1];
                if (dist[v][0] > cost + w) {
                    dist[v][0] = cost + w;
                    pq.offer(new int[]{dist[v][0], v, 0});
                }
            }
            if (used == 0) {
                for (int[] edge : incoming[u]) {
                    int v = edge[0], w = edge[1];
                    if (dist[v][0] > cost + 2 * w) {
                        dist[v][0] = cost + 2 * w;
                        pq.offer(new int[]{dist[v][0], v, 0});
                    }
                }
            }
        }
        
        int res = Math.min(dist[n-1][0], dist[n-1][1]);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
