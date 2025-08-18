class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()) 
            return false;
        
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();
        
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            
            if(map.containsKey(c)) {
                if(!map.get(c).equals(w)) return false;
            } else {
                map.put(c, w);
            }
            
            if(reverseMap.containsKey(w)) {
                if(reverseMap.get(w) != c) return false;
            } else {
                reverseMap.put(w, c);
            }
        }   
        return true;
    }
}