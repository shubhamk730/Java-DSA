package sorting;

// Average TC - O(N log N), Worst TC - O(N²)
// Average SC - O(log N) due to recursion stack
public class QuickSort {

    private static int partition(int[] arr, int pivot, int low, int high) {
        int pivotValue = arr[pivot];
        int i = low;
        int j = high;

        while (i < j) {

            while (i <= high && arr[i] <= pivotValue) {
                i++;
            }

            while (j >= low && arr[j] > pivotValue) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[pivot];
        arr[pivot] = arr[j];
        arr[j] = temp;

        return j;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int pivot = low;
        int partitionIndex = partition(arr, pivot, low, high);

        quickSort(arr, low, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, high);
    }

    public static void main(String[] args) {
        int[] arr = {123, 32, 54, 1, 5243, 655, 6};

        System.out.println("Before Sort:");
        for (int el : arr) {
            System.out.print(el + " ");
        }

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nAfter Sort:");
        for (int el : arr) {
            System.out.print(el + " ");
        }
    }
}