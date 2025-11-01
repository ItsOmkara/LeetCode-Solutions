class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            String prev = result.get(result.size() - 1);
            String current = words[i];
            if (!isAnagram(prev, current)) {
                result.add(current);
            }
            
        }
        
        return result;
    }
    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        int[] count = new int[26];
        for (char c : s1.toCharArray()) count[c - 'a']++;
        for (char c : s2.toCharArray()) count[c - 'a']--;
        
        for (int n : count) {
            if (n != 0) return false;
        }
        return true;
    }
}