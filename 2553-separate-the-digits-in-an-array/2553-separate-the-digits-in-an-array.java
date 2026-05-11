class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int num : nums){
            Stack<Integer> st = new Stack<>();

            while(num > 0){
                st.push(num % 10);
                num /= 10;
            }

            while(!st.isEmpty()){
                ans.add(st.pop());
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}