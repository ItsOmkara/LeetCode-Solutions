class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int totalCodes = 1 << k;
        if (n - k + 1 < totalCodes) {
            return false;
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= n - k; i++) {
            String sub = s.substring(i, i + k);
            set.add(sub);

            
            if (set.size() == totalCodes) {
                return true;
            }
        }
        return set.size() == totalCodes;
    }
}