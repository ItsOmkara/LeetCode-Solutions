class Solution {
    public int pivotInteger(int n) {
        int currSum = 0;
        int afterSum = 0;
        for(int i = 1;i<=n;i++){
            afterSum += i;
        }
        int pivot = -1;
        for(int i = 1;i<=n;i++){
            currSum = currSum + i;
            if(currSum == afterSum){
                return i;
            }
            afterSum = afterSum - i;
        }
        return pivot;
    }
}