class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<words.length;i++){
            String word = words[i];
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            ans.append(sb);
            if(i != words.length-1){
                ans.append(" ");
            }
        }
        return ans.toString();
    }
    
}