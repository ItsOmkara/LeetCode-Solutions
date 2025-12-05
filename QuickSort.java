public class QuickSort {
    public int quick(int arr[],int low,int high){
        int pivot = arr[high];
        int i = (low-1);

        for(int j=low;j<high;j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public void sort(int arr[],int low,int high){
        if(low<high) {
            int pi = quick(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
    public static void main(String args[]){
        QuickSort q = new QuickSort();
        int arr[] = {4,8,2,5,3,1};
        int n = arr.length - 1;
        q.sort(arr,0,n);
        for(int num:arr){
            System.out.println(num);
        }
    }
}
