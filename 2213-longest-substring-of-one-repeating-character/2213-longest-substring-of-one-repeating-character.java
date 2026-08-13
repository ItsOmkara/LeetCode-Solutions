class Solution {
    char[] leftC, rightC;
    int[] prefLen, sufLen, maxLen, segLen;
    char[] arr;
    int n;
    
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        n = s.length();
        arr = s.toCharArray();
        int size = 4 * n;
        leftC = new char[size];
        rightC = new char[size];
        prefLen = new int[size];
        sufLen = new int[size];
        maxLen = new int[size];
        segLen = new int[size];

        build(1, 0, n - 1);

        int k = queryCharacters.length();
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char c = queryCharacters.charAt(i);
            arr[idx] = c;
            update(1, 0, n - 1, idx);
            res[i] = maxLen[1];
        }
        return res;
    }

    private void build(int node, int l, int r) {
        if (l == r) {
            leftC[node] = rightC[node] = arr[l];
            prefLen[node] = sufLen[node] = maxLen[node] = 1;
            segLen[node] = 1;
            return;
        }
        int mid = (l + r) >>> 1;
        build(2 * node, l, mid);
        build(2 * node + 1, mid + 1, r);
        pull(node);
    }

    private void update(int node, int l, int r, int idx) {
        if (l == r) {
            leftC[node] = rightC[node] = arr[l];
            return;
        }
        int mid = (l + r) >>> 1;
        if (idx <= mid) update(2 * node, l, mid, idx);
        else update(2 * node + 1, mid + 1, r, idx);
        pull(node);
    }

    private void pull(int node) {
        int lft = 2 * node, rgt = 2 * node + 1;

        segLen[node] = segLen[lft] + segLen[rgt];
        leftC[node] = leftC[lft];
        rightC[node] = rightC[rgt];
        prefLen[node] = prefLen[lft];
        if (prefLen[lft] == segLen[lft] && rightC[lft] == leftC[rgt]) {
            prefLen[node] += prefLen[rgt];
        }
        sufLen[node] = sufLen[rgt];
        if (sufLen[rgt] == segLen[rgt] && rightC[lft] == leftC[rgt]) {
            sufLen[node] += sufLen[lft];
        }

        maxLen[node] = Math.max(maxLen[lft], maxLen[rgt]);
        if (rightC[lft] == leftC[rgt]) {
            maxLen[node] = Math.max(maxLen[node], sufLen[lft] + prefLen[rgt]);
        }
    }
}