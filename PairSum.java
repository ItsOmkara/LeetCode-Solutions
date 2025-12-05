import java.util.HashSet;

public class PairSum {
    public void Pairsum(int arr[],int target){
        HashSet<Integer> h = new HashSet<>();
        HashSet<String> s = new HashSet<>();
        for(Integer n:arr){
            int compliment = target - n;
            if(h.contains(compliment)){
                int first = Math.min(n,compliment);
                int second = Math.max(n,compliment);
                String pair = first + "," + second;
                if(!s.contains(pair)){
                    System.out.println("(" + first + "," + second + ")");
                    s.add(pair);
                }
            }
            h.add(n);
        }
    }
    public static void main(String args[]){
        PairSum p = new PairSum();
        int[] arr = {55,34,78,90,43,2,5};
        int k = 60;
        p.Pairsum(arr,k);
        int[] nums = {1, 4, 3, 2};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        String s = sb.toString();
        System.out.println(s);
    }
}
