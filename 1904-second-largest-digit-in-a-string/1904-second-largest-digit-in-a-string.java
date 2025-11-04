class Solution {
    public int secondHighest(String s) {
    String digits = s.replaceAll("\\D", "");
    int[] arr = new int[digits.length()];
    for(int i = 0; i < digits.length(); i++) {
        arr[i] = Character.getNumericValue(digits.charAt(i));
    }
    int highest = -1;
    int sec = -1;
    for(int i=0;i<arr.length;i++){
       if(highest<arr[i]){
        sec = highest;
        highest = arr[i];
       }
       if(arr[i] != highest && sec<arr[i]){
        sec = arr[i];
       } 
    }
    return sec;    
    }
}