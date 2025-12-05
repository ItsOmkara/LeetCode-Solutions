public class BinarySearch {
    public static void main(String args[]){
        int [] arr = {2,4,6,8,12};
        int t = 8;
        int left = 0;
        int right = arr.length - 1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(arr[mid] == t){
                System.out.println(mid);
            }
            else if(arr[mid] < t){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

    }
}
