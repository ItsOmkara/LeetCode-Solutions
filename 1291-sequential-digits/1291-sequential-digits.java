class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> l = new ArrayList<>();
        for(int i = 1;i<=9;i++){
            int num = i;
            int next = i + 1;

            while(next<=9){
                num = num * 10 + next;

                if(num >= low && num <= high){
                    l.add(num);
                }

                next++;
            }
        }

        Collections.sort(l);
        return l;
    }
}