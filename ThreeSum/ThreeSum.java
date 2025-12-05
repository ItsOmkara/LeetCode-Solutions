package ThreeSum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> Threesum(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length - 2;i++){
            int left = i + 1;
            int right = arr.length - 1;
            if(i>0 && arr[i] == arr[i- 1]) continue;

            while(left<right){
                int sum = arr[i] + arr[left] + arr[right];
                if( sum == 0){
                    res.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    left++;
                    right--;

                    while(left<right && arr[left] == arr[left + 1]) left++;
                    while(left<right && arr[right] == arr[right - 1]) right --;
                }
                else if(sum<0){
                    left++;
                }
                else{
                    right--;
                }
            }

        }
        return res;
    }
    public static void main(String args[]){
        int arr[] = {-1,0,1,2,-1,-4};
        System.out.println(ThreeSum.Threesum(arr));
    }
}
