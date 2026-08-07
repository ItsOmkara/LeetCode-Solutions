public class Solution {

    public static String smallestNumber(String num, long t) {
        PrimeResult primeResult = getPrimeCount(t);
        Map<Integer, Integer> primeCount = primeResult.count;

        if (!primeResult.isDivisible) {
            return "-1";
        }

        Map<Integer, Integer> factorCount = getFactorCount(primeCount);

        if (sumValues(factorCount) > num.length()) {
            return construct(factorCount);
        }

        Map<Integer, Integer> primeCountPrefix =
                getPrimeCountFromString(num);

        int firstZeroIndex = num.indexOf('0');

        if (firstZeroIndex == -1) {
            firstZeroIndex = num.length();

            if (isSubset(primeCount, primeCountPrefix)) {
                return num;
            }
        }

        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';

            primeCountPrefix = subtract(
                    primeCountPrefix,
                    K_FACTOR_COUNTS.get(digit)
            );

            int spaceAfterThisDigit = num.length() - 1 - i;

            if (i > firstZeroIndex) {
                continue;
            }

            for (int biggerDigit = digit + 1;
                 biggerDigit < 10;
                 biggerDigit++) {

                Map<Integer, Integer> remainingFactors =
                        subtract(
                                subtract(
                                        primeCount,
                                        primeCountPrefix
                                ),
                                K_FACTOR_COUNTS.get(biggerDigit)
                        );

                Map<Integer, Integer> factorsAfterReplacement =
                        getFactorCount(remainingFactors);

                int requiredDigits = sumValues(factorsAfterReplacement);

                if (requiredDigits <= spaceAfterThisDigit) {
                    int fillOnes = spaceAfterThisDigit - requiredDigits;

                    return num.substring(0, i)
                            + biggerDigit
                            + "1".repeat(fillOnes)
                            + construct(factorsAfterReplacement);
                }
            }
        }

        Map<Integer, Integer> factorsAfterExtension =
                getFactorCount(primeCount);

        int requiredDigits = sumValues(factorsAfterExtension);

        int onesCount = num.length() + 1 - requiredDigits;

        return "1".repeat(onesCount)
                + construct(factorsAfterExtension);
    }

    private static final Map<Integer, Map<Integer, Integer>>
            K_FACTOR_COUNTS = new HashMap<>();

    static {
        K_FACTOR_COUNTS.put(0, new HashMap<>());
        K_FACTOR_COUNTS.put(1, new HashMap<>());
        K_FACTOR_COUNTS.put(2, mapOf(2, 1));
        K_FACTOR_COUNTS.put(3, mapOf(3, 1));
        K_FACTOR_COUNTS.put(4, mapOf(2, 2));
        K_FACTOR_COUNTS.put(5, mapOf(5, 1));
        K_FACTOR_COUNTS.put(6, mapOf(2, 1, 3, 1));
        K_FACTOR_COUNTS.put(7, mapOf(7, 1));
        K_FACTOR_COUNTS.put(8, mapOf(2, 3));
        K_FACTOR_COUNTS.put(9, mapOf(3, 2));
    }

    private static Map<Integer, Integer> mapOf(int... values) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < values.length; i += 2) {
            map.put(values[i], values[i + 1]);
        }

        return map;
    }

    private static PrimeResult getPrimeCount(long t) {
        Map<Integer, Integer> count = new HashMap<>();

        count.put(2, 0);
        count.put(3, 0);
        count.put(5, 0);
        count.put(7, 0);

        int[] primes = {2, 3, 5, 7};

        for (int prime : primes) {
            while (t % prime == 0) {
                t /= prime;
                count.put(prime, count.get(prime) + 1);
            }
        }

        return new PrimeResult(count, t == 1);
    }

    private static Map<Integer, Integer>
    getPrimeCountFromString(String num) {
        Map<Integer, Integer> count = new HashMap<>();

        count.put(2, 0);
        count.put(3, 0);
        count.put(5, 0);
        count.put(7, 0);

        for (char character : num.toCharArray()) {
            int digit = character - '0';

            for (Map.Entry<Integer, Integer> entry :
                    K_FACTOR_COUNTS.get(digit).entrySet()) {

                int prime = entry.getKey();
                int frequency = entry.getValue();

                count.put(
                        prime,
                        count.get(prime) + frequency
                );
            }
        }

        return count;
    }

    private static Map<Integer, Integer>
    getFactorCount(Map<Integer, Integer> count) {
        Map<Integer, Integer> result = new HashMap<>();

        int count8 = count.get(2) / 3;
        int remaining2 = count.get(2) % 3;

        int count9 = count.get(3) / 2;
        int count3 = count.get(3) % 2;

        int count4 = remaining2 / 2;
        int count2 = remaining2 % 2;

        int count6 = 0;

        if (count2 == 1 && count3 == 1) {
            count2 = 0;
            count3 = 0;
            count6 = 1;
        }

        if (count3 == 1 && count4 == 1) {
            count2 = 1;
            count6 = 1;
            count3 = 0;
            count4 = 0;
        }

        result.put(2, count2);
        result.put(3, count3);
        result.put(4, count4);
        result.put(5, count.get(5));
        result.put(6, count6);
        result.put(7, count.get(7));
        result.put(8, count8);
        result.put(9, count9);

        return result;
    }

    private static String construct(Map<Integer, Integer> factors) {
        StringBuilder result = new StringBuilder();

        for (int digit = 2; digit < 10; digit++) {
            int frequency = factors.getOrDefault(digit, 0);
            result.append(String.valueOf(digit).repeat(frequency));
        }

        return result.toString();
    }

    private static boolean isSubset(
            Map<Integer, Integer> first,
            Map<Integer, Integer> second) {

        for (Map.Entry<Integer, Integer> entry : first.entrySet()) {
            int prime = entry.getKey();
            int requiredFrequency = entry.getValue();

            if (second.getOrDefault(prime, 0) < requiredFrequency) {
                return false;
            }
        }

        return true;
    }

    private static Map<Integer, Integer> subtract(
            Map<Integer, Integer> first,
            Map<Integer, Integer> second) {

        Map<Integer, Integer> result = new HashMap<>(first);

        for (Map.Entry<Integer, Integer> entry : second.entrySet()) {
            int prime = entry.getKey();
            int frequency = entry.getValue();

            result.put(
                    prime,
                    Math.max(
                            0,
                            result.getOrDefault(prime, 0) - frequency
                    )
            );
        }

        return result;
    }

    private static int sumValues(Map<Integer, Integer> count) {
        int sum = 0;

        for (int value : count.values()) {
            sum += value;
        }

        return sum;
    }

    private static class PrimeResult {
        Map<Integer, Integer> count;
        boolean isDivisible;

        PrimeResult(
                Map<Integer, Integer> count,
                boolean isDivisible) {

            this.count = count;
            this.isDivisible = isDivisible;
        }
    }
}