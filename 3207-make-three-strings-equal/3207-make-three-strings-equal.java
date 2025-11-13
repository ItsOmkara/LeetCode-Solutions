class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int n = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        int commonPrefix = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
                commonPrefix++;
            } else break;
        }

        if (commonPrefix == 0) return -1; // nothing in common

        int ops = (s1.length() - commonPrefix)
                + (s2.length() - commonPrefix)
                + (s3.length() - commonPrefix);
        return ops;
    }
}
