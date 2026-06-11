import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1; 
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        int[] depth = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        depth[1] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    depth[neighbor] = depth[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        int maxDepth = 0;
        for (int i = 1; i <= n; i++) {
            maxDepth = Math.max(maxDepth, depth[i]);
        }
        
        if (maxDepth == 0) {
            return 0; 
        }
        
        return power(2, maxDepth - 1);
    }
    
    private int power(int base, int exponent) {
        long result = 1;
        long current = base;
        long exp = exponent;
        
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * current) % MOD;
            }
            current = (current * current) % MOD;
            exp /= 2;
        }
        
        return (int) result;
    }
}