class Solution {
    public int thirdMax(int[] nums) {
        Integer Firstmax = null;
        Integer secMax = null;
        Integer thirdMax = null;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if ((Firstmax != null && num == Firstmax) ||
                (secMax != null && num == secMax) ||
                (thirdMax != null && num == thirdMax)) {
                continue;
            }

            if (Firstmax == null || num > Firstmax) {
                thirdMax = secMax;
                secMax = Firstmax;
                Firstmax = num;
            }
            else if (secMax == null || num > secMax) {
                thirdMax = secMax;
                secMax = num;
            }
            else if (thirdMax == null || num > thirdMax) {
                thirdMax = num;
            }
        }

        return thirdMax == null ? Firstmax : thirdMax;
    }
}