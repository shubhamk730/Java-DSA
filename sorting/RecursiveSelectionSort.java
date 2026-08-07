package sorting;

public class RecursiveSelectionSort {

    static void selectionSort(int[] arr, int row, int col, int maxIndex) {

        // Outer recursion base case
        if (row == 0) {
            return;
        }

        // Find maximum recursively
        if (col <= row) {

            if (arr[col] > arr[maxIndex]) {
                maxIndex = col;
            }

            selectionSort(arr, row, col + 1, maxIndex);

        } else {

            // Swap maximum with last element
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[row];
            arr[row] = temp;

            // Next pass
            selectionSort(arr, row - 1, 0, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        selectionSort(arr, arr.length - 1, 0, 0);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
