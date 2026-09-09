class Solution {
    public long countCommas(long n) {
        long answer = 0;
        long threshold = 1_000;

        while (threshold <= n) {
            answer += n - threshold + 1;
            if (threshold > n / 1000) {
                break;
            }

            threshold *= 1000;
        }

        return answer;
    }
}