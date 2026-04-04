class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == 0){
                nums1[i] = nums2[j];
                j++;
            }
            i++;
        }

        Arrays.sort(nums1);
        List<Integer> l = new ArrayList<>();
        for(int k = 0;k<nums1.length;k++){
            l.add(nums1[k]);
        }
        System.out.println(l);
    }
}