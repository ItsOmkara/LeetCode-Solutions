public class InsertionSort {
    public static void main(String args[]){
        int arr[] = {29, 10, 14, 37, 13};
        int size = arr.length;
        for(int i=1;i<size;i++){
            int key = arr[i];
            int j = i - 1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
