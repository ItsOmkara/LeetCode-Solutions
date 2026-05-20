class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B){
        int n = A.length;
        int[] arr = new int[n];

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        
        for(int i = 0;i<n;i++){
            set1.add(A[i]);
            set2.add(B[i]);

            int count = 0;
            for(int x:set1){
                if(set2.contains(x)){
                    count++;
                }
            }
            arr[i] = count;
        }
        return arr;
    }
}