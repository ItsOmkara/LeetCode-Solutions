class Solution {
    public int mirrorDistance(int n) {
        if(n<10){
            return n - n;
        }
        int reverse = 0;
        int num = n;
        while(n>0){
            reverse = reverse * 10 + (n % 10);
            n = n/10;
        }
        int result = Math.abs(num - reverse);
        return result;
    }
}