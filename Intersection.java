import java.util.*;
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int num : nums1){
            set1.add(num);
        }

        Set<Integer> resultSet = new HashSet<>();
        for(int num : nums2){
            if(set1.contains(num)){
                resultSet.add(num);
            }
        }

        // Convert Set to int[]
        int[] result = new int[resultSet.size()];
        int i = 0;
        for(int num : resultSet){
            result[i++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        Intersection obj = new Intersection();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] ans = obj.intersection(nums1, nums2);
        System.out.println(Arrays.toString(ans));
        // Output: [4, 9] or [9, 4] (order doesn't matter)
    }
}
