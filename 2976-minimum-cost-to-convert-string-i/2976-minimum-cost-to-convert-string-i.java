class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        final long INF = 1L << 40; 
        long[][] g = new long[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                g[i][j] = (i == j) ? 0 : INF;
            }
        }

        for (int i = 0; i < original.length; i++) {
            int x = original[i] - 'a';
            int y = changed[i] - 'a';
            g[x][y] = Math.min(g[x][y], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (g[i][k] < INF && g[k][j] < INF) {
                        g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                    }
                    
                }
            }
        }
        
        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                int x = source.charAt(i) - 'a';
                int y = target.charAt(i) - 'a';
                if (g[x][y] >= INF) {
                    return -1;
                }
                ans += g[x][y];
            }
        }
        return ans;
    }
}