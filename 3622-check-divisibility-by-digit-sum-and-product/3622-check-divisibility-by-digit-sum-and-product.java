class Solution {
    public boolean checkDivisibility(int n) {
        int m = n;
        String s = String.valueOf(n);
        if(s.length() == 1){
            return false;
        }
        int n1 = 0;
        int n2 = 0;
        int tSum = 0;
        int tProduct = 1;
        for(int i = 0;i<s.length();i++){
            if(s.length() == 2){
                if(i % 2  == 0){
                    n1 += s.charAt(i) - '0'; 
                }
                else{
                    n2 += s.charAt(i) - '0';
                }
            }
            else{
                tSum += s.charAt(i) - '0';
                tProduct *= s.charAt(i) - '0';
            }
        }
        if(n1 == 0 && n2 == 0){
            int ans = tSum + tProduct;
            if(m % ans == 0){
                return true;
            }
        }
        else{
            int result = n1 + n2;
            result = result + (n1 * n2);
            if(m % result == 0){
                return true;
            }
        }

        return false;
    }
}