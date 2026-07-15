class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;
        int l = 2 * n;
        for(int i = 1;i<=l;i++){
            if(i % 2 == 0){
            sumOdd += i; 
            }
            else{
                sumEven += i;
            }
        }

        int result = gcd(sumOdd,sumEven);
        return result;
    }
    public static int gcd(int n1,int n2){
        while(n2 != 0){
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }

        return n1;
    }
}