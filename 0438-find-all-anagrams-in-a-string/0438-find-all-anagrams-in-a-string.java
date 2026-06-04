class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> l = new ArrayList<>();
        int right = p.length();
        for(int i = 0;i<=s.length() - p.length();i++){
            String r = s.substring(i,right);
            int[]freq = new int[256];
            for(int j = 0;j<r.length();j++){
                freq[r.charAt(j)]++;
                freq[p.charAt(j)]--;
            }
            boolean anagram = true;
            for(int k = 0; k < freq.length; k++){
                if(freq[k] != 0){
                    anagram = false;
                    break;
                }
            }
            if(anagram){
                l.add(i);
            }
            right++;
        }
        return l;
    }
}