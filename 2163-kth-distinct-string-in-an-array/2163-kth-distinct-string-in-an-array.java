class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> m = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            m.put(arr[i],m.getOrDefault(arr[i],0) + 1);
        }
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(m.get(arr[i]) == 1){
                count++;
                if(count == k){
                    return arr[i];
                }
            }
        }
        return "";

    }
}