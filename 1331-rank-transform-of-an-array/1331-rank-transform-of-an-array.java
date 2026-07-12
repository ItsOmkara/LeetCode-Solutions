class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int n = arr.length;

        int[] rep = arr.clone();
        Arrays.sort(rep);

        Map<Integer, Integer> map = new HashMap<>();

        int rank = 1;

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(rep[i])) {
                map.put(rep[i], rank++);
            }
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }
}