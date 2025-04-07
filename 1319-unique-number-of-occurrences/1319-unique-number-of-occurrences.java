import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        
        Set<Integer> seenFreq = new HashSet<>();

        for (int freq : freqMap.values()) {
            if (seenFreq.contains(freq)) {
                return false; 
            }
            seenFreq.add(freq);
        }

        return true; 
    }
}
