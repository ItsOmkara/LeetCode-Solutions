public class SmallestNum {
    public int Checkin(int[] nums1, int[] nums2){
        int check = Integer.MAX_VALUE;
        for(int num1:nums1){
            for(int num2:nums2){
                if(num1 == num2){
                    if(num1<check){
                        check = num1;
                    }
                }
            }
        }

        if(check != Integer.MAX_VALUE){
            return check;
        }

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int num1:nums1){
            min1 = Math.min(min1,num1);
        }

        for(int num2:nums2){
            min2 = Math.min(min2,num2);
        }

        return Math.min(min1 * 10 + min2 , min2 * 10 + min1);
    }
    public static void main(String args[]){
        int arr1[] = {3,2,4};
        int arr2[] = {7,8,9};
        SmallestNum ar = new SmallestNum();
        System.out.println(ar.Checkin(arr1,arr2));
    }
}
