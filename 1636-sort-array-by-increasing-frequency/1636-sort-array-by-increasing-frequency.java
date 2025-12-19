class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> {
            int fa = freq.get(a); 
            int fb = freq.get(b);

            if (fa != fb) {
                return fa - fb;      
            } else {
                return b - a;        
            }
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}