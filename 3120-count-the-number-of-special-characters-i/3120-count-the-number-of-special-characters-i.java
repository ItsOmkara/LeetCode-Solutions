class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        List<Character> l = new ArrayList<>();
        for(int i = 0;i<word.length();i++){
           l.add(word.charAt(i));
        }
        for(int i = 0;i<l.size();i++){
            char ch = l.get(i);
            char chl = Character.toLowerCase(ch);
            char chU = Character.toUpperCase(ch);
            if(ch == chl){
                for(int j = 0;j<l.size();j++){
                    if(l.get(j) == chU){
                        set.add(chU);
                    }
                }
            }
        }
        return set.size();
    }
}