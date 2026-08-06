package sorting;


// divide and merge
// TC - O(Nlog(N)), SC- O(N)
public class MergeSort {

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp =  new int[high-low+1];
        int idx = 0;

        int i = low, j = mid + 1;
        while(i<= mid && j <= high) {
            if(arr[i] <= arr[j]){
                temp[idx] = arr[i];
                i++;
            } else {
                temp[idx] = arr[j];
                j++;
            }
            idx++;
        }

        while(i <= mid) {
            temp[idx] = arr[i];
            i++;
            idx++;
        }


        while(j <= high) {
            temp[idx] = arr[j];
            j++;
            idx++;
        }

        for (i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }
    
    private static void mergeSort(int[] arr, int low, int high) {
        if(low >= high){
            return;
        }

        int mid = (low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }
    

    public static void main(String[] args) {
        int[] arr = new int[]{123,32,54,1,5243,655,6};
        int low = 0, high = arr.length - 1;
        System.out.println("Before Sort:-");
        for(var el : arr) {
            System.out.print(el + " ");
        }
        System.out.println("--------------------------");
        mergeSort(arr, low, high);
        System.out.println("After Sort:-");
        for(var el : arr) {
            System.out.print(el + " ");
        }
    }

}
