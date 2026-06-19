class Solution {
    public int largestAltitude(int[] gain) {
        int highest = 0;
        int highest2=0;
        for(int i=0;i<gain.length;i++){
           highest2 += gain[i];
           if(highest<highest2){
            highest = highest2;
           }
        }
        return highest;
    }
}