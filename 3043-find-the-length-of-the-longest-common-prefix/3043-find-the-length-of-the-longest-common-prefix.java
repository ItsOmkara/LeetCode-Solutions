class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set  = new HashSet<>();
        for(int i = 0;i<arr1.length;i++){
            while(arr1[i] > 0){
                set.add(arr1[i]);
                arr1[i] = arr1[i]/10;
            }
        }

        int max = 0;
        for(int num:arr2){
            while(num>0){
                if(set.contains(num)){
                    max = Math.max(max,String.valueOf(num).length());
                    break;
                }
                num/=10;
            }
        }
        return max;
    }
}