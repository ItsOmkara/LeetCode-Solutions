class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        String vowels = "aeiou";
        int count = 0;
        for(int i=left; i<=right; i++){
            String w = words[i];
            char first = w.charAt(0);
            char last = w.charAt(w.length() - 1);

            if(vowels.indexOf(first) != -1 && vowels.indexOf(last) != -1){
                count++;
            }
        }
        return count;
    }
}