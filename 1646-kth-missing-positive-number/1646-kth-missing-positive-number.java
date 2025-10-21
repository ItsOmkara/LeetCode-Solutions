class Solution {
    public int findKthPositive(int[] arr, int k) {
        int count = 0;
        int num = 1;
        int i = 0;
        while(count<k){
            if(i < arr.length && arr[i] == num){
                i++;
            }
            else{
                count++;
                if(count == k){
                    return num;
                }
            }
            num++;
        }
        return -1;
    }
}