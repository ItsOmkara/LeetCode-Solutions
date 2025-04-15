import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        
        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();
        
        for (char c : word1.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }
        
        for (char c : word2.toCharArray()) {
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);
        }
        
        if (!freq1.keySet().equals(freq2.keySet())) {
            return false;
        }
        
        int[] counts1 = freq1.values().stream().mapToInt(Integer::intValue).toArray();
        int[] counts2 = freq2.values().stream().mapToInt(Integer::intValue).toArray();
        
        Arrays.sort(counts1);
        Arrays.sort(counts2);
        
        return Arrays.equals(counts1, counts2);
    }
}