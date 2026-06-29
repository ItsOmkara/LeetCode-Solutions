class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for(int i=0;i<patterns.length;i++){
            boolean result = word.contains(patterns[i]);
            if(result){
                count++;
            }
        }
        return count;
    }
}