package sorting;

// TC - O(NLog(N)), SC- O(1)
// 1. Pick a pivot and place it at correct position in sorted array ( pivot can first, last, median or random element of the array)
// 2. Smaller on the left and larger on the right
public class QuickSort {

    private static int pivotize(int[] arr, int pivot, int low, int high) {
        int i = low, j = high;

        while(i <= j) {

            while(arr[i] <= arr[pivot]) {
                i++;
            }

            while(arr[j] >= arr[pivot]){
                j--;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        int temp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = temp;

        return j;

    }

    private static void quickSort(int[] arr, int low, int high) {
        if( low >= high ) return;

        int pivot = low;
        int partitionIndex = pivotize(arr, pivot, low, high);
        quickSort(arr, low, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, high);

    }


    public static void main(String[] args) {
        int[] arr = new int[]{123,32,54,1,5243,655,6};
        int low = 0, high = arr.length - 1;
        System.out.println("Before Sort:-");
        for(var el : arr) {
            System.out.print(el + " ");
        }
        System.out.println("--------------------------");
        quickSort(arr, low, high);
        System.out.println("After Sort:-");
        for(var el : arr) {
            System.out.print(el + " ");
        }
    }

}
