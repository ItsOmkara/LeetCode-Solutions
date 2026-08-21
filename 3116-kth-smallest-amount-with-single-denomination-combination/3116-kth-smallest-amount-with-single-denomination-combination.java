class Solution {
    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long high = 1L * coins[0] * k;

        while (low < high) {

            long mid = low + (high - low) / 2;

            long count = countAmounts(mid, coins);

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long countAmounts(long x, int[] coins) {

        long count = 0;
        int n = coins.length;

        // Inclusion-exclusion
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {
                    bits++;

                    lcm = getLCM(lcm, coins[i]);

                    // LCM became larger than x
                    if (lcm > x) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) {
                continue;
            }

            long current = x / lcm;

            if (bits % 2 == 1) {
                count += current;
            } else {
                count -= current;
            }
        }

        return count;
    }

    private long getLCM(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}