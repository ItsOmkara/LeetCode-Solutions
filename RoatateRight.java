public class RoatateRight {
    void roatate(int arr[],int k){
        int n = arr.length;
        k = k%n;

        move(arr,0,n-1);
        move(arr,0,k-1);
        move(arr,k,n-1);
    }

    void move(int arr[],int start,int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String args[]){
        RoatateRight r = new RoatateRight();
        int arr[] = {2,3,4,5,6};
        int k = 2;
        r.roatate(arr,k);
        for(int n:arr){
            System.out.print(n + " ");
        }

        int a = 10;
        int b = 3;
        System.out.println();
        System.out.println(a/b);
    }
}
