class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer, Integer> numFreq = new HashMap<>();

        for (int num : nums) {
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, Integer> freqFreq = new HashMap<>();

        for (int freq : numFreq.values()) {
            freqFreq.put(freq, freqFreq.getOrDefault(freq, 0) + 1);
        }

        for (int num : nums) {
            int freq = numFreq.get(num);

            if (freqFreq.get(freq) == 1) {
                return num;
            }
        }

        return -1;
    }
}