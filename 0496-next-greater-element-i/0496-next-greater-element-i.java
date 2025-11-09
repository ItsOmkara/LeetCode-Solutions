class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack();
        for(int i=0;i<nums1.length;i++){
            boolean found = false;
            for(int j = 0;j<nums2.length;j++){
               if(nums1[i] == nums2[j]){
                 found = true;
               }
               else if(found && nums2[j] > nums1[i]){
                stack.push(nums2[j]);
                found = false;
                break;
               }
            }
            if(found) stack.push(-1);
        }
        int[] intArray = stack.stream()
                              .mapToInt(Integer::intValue) 
                              .toArray();
        return intArray;                      
    }
}