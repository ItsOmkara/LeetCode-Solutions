class Solution {
    public int countPrimeSetBits(int left, int right) {
        boolean[] isPrime = new boolean[21];
        isPrime[2] = isPrime[3] = isPrime[5] = isPrime[7] = 
        isPrime[11] = isPrime[13] = isPrime[17] = isPrime[19] = true;
        
        int count = 0;
        for (int num = left; num <= right; num++) {
            int setBits = Integer.bitCount(num);
            if (isPrime[setBits]) {
                count++;
            }
        }
        
        return count;
    }
}