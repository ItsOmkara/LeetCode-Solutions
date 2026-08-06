class Solution {
    public int smallestNumber(int n, int t) {
        while(n > 0){
            int product = 1;
            String s = String.valueOf(n);
            for(int i = 0;i<s.length();i++){
                product *= (s.charAt(i) - '0');
            }
            if(product % t == 0){
                break;
            }
            n++;
        }
        return n;
    }
}