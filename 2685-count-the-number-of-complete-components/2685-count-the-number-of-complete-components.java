class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        for (int[] edge : edges) {
            union(parent, edge[0], edge[1]);
        }
        
        int[] vertexCount = new int[n];
        int[] edgeCount = new int[n];
        
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            vertexCount[root]++;
        }
        
        for (int[] edge : edges) {
            int root = find(parent, edge[0]);
            edgeCount[root]++;
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                long v = vertexCount[i];
                long e = edgeCount[i];
                if (e == v * (v - 1) / 2) {
                    result++;
                }
            }
        }
        
        return result;
    }
    
    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]]; 
            x = parent[x];
        }
        return x;
    }
    
    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }
}