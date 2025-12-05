public class SelectionSort {
    public static void main(String args[]){
        int arr[] = {29,10,14,37,13};
        int size = arr.length;
        for(int i=0;i<size-1;i++){
            int min = i;
            for(int j = i+1;j<size;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        for(int i=0;i<size;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
