class Solution {
    public int numberOfSpecialChars(String word) {
        int count  = 0;
        for(char i = 'a';i<='z';i++){
            int lastLower = word.lastIndexOf(i);
            int firstUpper = word.indexOf(Character.toUpperCase(i));

            if(lastLower != -1 &&
               firstUpper != -1 &&
               lastLower < firstUpper){

                count++;
            }
        }
        return count;
    }
}