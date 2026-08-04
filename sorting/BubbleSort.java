package sorting;

public class BubbleSort {

    private static void sort(int[] arr) {
        int n = arr.length;

        // n-1 passes
        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            // Compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swaps occurred, array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {123, 32, 54, 1, 5243, 655, 6};

        sort(arr);

        for (int el : arr) {
            System.out.print(el + " ");
        }
    }
}