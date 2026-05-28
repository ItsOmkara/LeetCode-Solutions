class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int bestIndex = -1;
    }

    TrieNode root = new TrieNode();

    void insert(String word, int index, String[] wordsContainer) {
        TrieNode node = root;

        node.bestIndex = getBest(node.bestIndex, index, wordsContainer);

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (node.children[c] == null) {
                node.children[c] = new TrieNode();
            }

            node = node.children[c];

            node.bestIndex = getBest(node.bestIndex, index, wordsContainer);
        }
    }
    int query(String word, String[] wordsContainer) {
        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (node.children[c] == null) {
                return node.bestIndex;
            }

            node = node.children[c];
        }

        return node.bestIndex;
    }

    int getBest(int existing, int newIdx, String[] wordsContainer) {
        if (existing == -1) return newIdx;

        int existLen = wordsContainer[existing].length();
        int newLen   = wordsContainer[newIdx].length();
        if (newLen < existLen) return newIdx;
        return existing; 
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i, wordsContainer);
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = query(wordsQuery[i], wordsContainer);
        }

        return ans;
    }
}