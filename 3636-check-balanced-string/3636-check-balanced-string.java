class Solution {
    public boolean isBalanced(String num) {
       int arr[] = num.chars().map(Character::getNumericValue).toArray();
       int sum = 0;
       int odd = 0;
       for(int i=0;i<arr.length;i++){
        if(i%2==0){
            sum+=arr[i];
        }
        else{
            odd+=arr[i];
        }
       }
       if(sum == odd){
        return true;
       }
       return false;
    }
}