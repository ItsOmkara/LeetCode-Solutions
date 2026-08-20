class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l1.add(nums[0]);
        l2.add(nums[1]);
        
        for(int i = 2;i<nums.length;i++){
            int curr = Math.max(l1.get(l1.size() - 1),l2.get(l2.size() - 1));
            if(l1.get(l1.size() - 1) == curr){
                l1.add(nums[i]);
            }
            else{
                l2.add(nums[i]);
            }
        }
        
        List<Integer> l3 = new ArrayList<>();
        for(int i = 0;i<l1.size();i++){
            l3.add(l1.get(i));
            
        }
        for(int j = 0;j<l2.size();j++){
            l3.add(l2.get(j)); 
        }

        int []arr = l3.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}