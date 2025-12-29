class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> l = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            String current = words[i];
            
            for (int j = 0; j < words.length; j++) {
                
                if (i == j) continue;
                
                String other = words[j];
                
                
                if (current.contains(other) && !l.contains(other)) {
                    l.add(other);
                } else if (other.contains(current) && !l.contains(current)) {
                    l.add(current);
                }
            }
        }
        return l;
    }
}