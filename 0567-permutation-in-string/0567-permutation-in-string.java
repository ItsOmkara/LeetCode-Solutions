class Solution {
    public boolean checkInclusion(String s1, String s2) {
        boolean found = false;

        if (s1.length() <= s2.length()) {
            int[] need = new int[26];
            int[] window = new int[26];

            for (int i = 0; i < s1.length(); i++) {
                need[s1.charAt(i) - 'a']++;
                window[s2.charAt(i) - 'a']++;
            }

            if (java.util.Arrays.equals(need, window)) {
                found = true;
            }

            for (int right = s1.length(); right < s2.length() && !found; right++) {
                window[s2.charAt(right) - 'a']++;                      
                window[s2.charAt(right - s1.length()) - 'a']--;        

                if (java.util.Arrays.equals(need, window)) {
                    found = true;
                }
            }
        }

     return found;
    }    
}