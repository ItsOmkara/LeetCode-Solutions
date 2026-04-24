class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        char[] arr = moves.toCharArray();
        int left = 0;
        int right = 0;
        int under = 0;
        int result = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 'L'){
                left++;
            }
            else if(arr[i] == 'R'){
                right++;
            }
            else{
                under++;
            }
        }

        if(left == right){
            result = (right + under) - left;
        }
        result = left > right ? (left + under) - right: (right + under) - left;
        return result;
    }
}