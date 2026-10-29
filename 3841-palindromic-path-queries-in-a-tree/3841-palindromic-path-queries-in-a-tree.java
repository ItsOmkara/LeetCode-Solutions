class Solution {
    int[] tin, tout, depth, bit;
    int[][] up;
    int n, LOG;

    void add(int i, int v) {
        for (i++; i <= n + 1; i += i & -i) bit[i] ^= v;
    }

    int point(int i) {
        int r = 0;
        for (i++; i > 0; i -= i & -i) r ^= bit[i];
        return r;
    }

    void rangeXor(int l, int r, int v) {
        add(l, v);
        add(r + 1, v);
    }

    int lca(int a, int b) {
        if (depth[a] < depth[b]) { int t = a; a = b; b = t; }
        int diff = depth[a] - depth[b];
        for (int k = 0; k < LOG; k++)
            if ((diff >> k & 1) == 1) a = up[k][a];
        if (a == b) return a;
        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][a] != up[k][b]) {
                a = up[k][a];
                b = up[k][b];
            }
        }
        return up[0][a];
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        LOG = 1;
        while ((1 << LOG) < n) LOG++;

        // adjacency list
        int[] head = new int[n], nxt = new int[2 * (n - 1)], to = new int[2 * (n - 1)];
        Arrays.fill(head, -1);
        int cnt = 0;
        for (int[] e : edges) {
            to[cnt] = e[1]; nxt[cnt] = head[e[0]]; head[e[0]] = cnt++;
            to[cnt] = e[0]; nxt[cnt] = head[e[1]]; head[e[1]] = cnt++;
        }

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        up = new int[LOG][n];
        bit = new int[n + 3];

        // iterative DFS
        int[] stack = new int[n], it = new int[n];
        int sp = 0, timer = 0;
        stack[sp++] = 0;
        up[0][0] = 0;
        tin[0] = timer++;
        System.arraycopy(head, 0, it, 0, n);
        while (sp > 0) {
            int v = stack[sp - 1];
            if (it[v] != -1) {
                int e = it[v];
                it[v] = nxt[e];
                int w = to[e];
                if (w == up[0][v] && v != 0) continue;
                if (v == 0 && w == 0) continue;
                up[0][w] = v;
                depth[w] = depth[v] + 1;
                tin[w] = timer++;
                stack[sp++] = w;
            } else {
                tout[v] = timer - 1;
                sp--;
            }
        }

        for (int k = 1; k < LOG; k++)
            for (int v = 0; v < n; v++)
                up[k][v] = up[k - 1][up[k - 1][v]];

        char[] c = s.toCharArray();
        for (int v = 0; v < n; v++)
            rangeXor(tin[v], tout[v], 1 << (c[v] - 'a'));

        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            String[] p = q.split(" ");
            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char nc = p[2].charAt(0);
                int delta = (1 << (c[u] - 'a')) ^ (1 << (nc - 'a'));
                if (delta != 0) {
                    rangeXor(tin[u], tout[u], delta);
                    c[u] = nc;
                }
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);
                int l = lca(u, v);
                int mask = point(tin[u]) ^ point(tin[v]) ^ (1 << (c[l] - 'a'));
                ans.add((mask & (mask - 1)) == 0);
            }
        }
        return ans;
    }
}