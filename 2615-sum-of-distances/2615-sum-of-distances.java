class Solution {
    public long[] distance(int[] nums) {
        // long[] num = new long[nums.length];
        // int[] brr = new int[nums.length];
        // for(int i = 0;i<brr.length;i++){
        //     brr[i] = nums[i];
        // }
        // for(int i = 0;i<nums.length;i++){
        //     int result = 0;
        //     for(int j = 0;j<brr.length;j++){
        //         if(nums[i] == brr[j]){
        //             result += Math.abs(i - j);
        //         }
        //     }
        //     if(result != 0){
        //         num[i] = (long)result;
        //     }
        //     else{
        //         num[i] = 0;
        //     }
        // }
        // return num;

        int n = nums.length;
        long[] res = new long[n];

        Map<Integer, Long> count = new HashMap<>();
        Map<Integer, Long> sum = new HashMap<>();

        // LEFT PASS
        for (int i = 0; i < n; i++) {
            int val = nums[i];

            if (count.containsKey(val)) {
                res[i] += count.get(val) * i - sum.get(val);
            }

            count.put(val, count.getOrDefault(val, 0L) + 1);
            sum.put(val, sum.getOrDefault(val, 0L) + i);
        }

        // reset maps
        count.clear();
        sum.clear();

        // RIGHT PASS
        for (int i = n - 1; i >= 0; i--) {
            int val = nums[i];

            if (count.containsKey(val)) {
                res[i] += sum.get(val) - count.get(val) * i;
            }

            count.put(val, count.getOrDefault(val, 0L) + 1);
            sum.put(val, sum.getOrDefault(val, 0L) + i);
        }

        return res;
    }
}