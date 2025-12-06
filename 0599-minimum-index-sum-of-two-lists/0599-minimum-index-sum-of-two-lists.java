class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> m = new HashMap<>();
        for(int i=0;i<list1.length;i++){
            m.put(list1[i],i);
        }
        int minSum = Integer.MAX_VALUE;
        List<String> ans = new ArrayList<>();

        for(int i = 0; i < list2.length; i++){
            String curr = list2[i];

            if(m.containsKey(curr)){
                int sum = i + m.get(curr);

                if(sum < minSum){
                    ans.clear();         
                    ans.add(curr);
                    minSum = sum;
                } 
                else if(sum == minSum){
                    ans.add(curr);       
                }
            }
        }

        return ans.toArray(new String[ans.size()]);
    }
}