package sorting;

public class RecursiveBubbleSort {

    static void bubbleSort(int[] arr, int row, int col) {
        // Outer recursion base case
        if (row == 0) {
            return;
        }

        // Inner recursion
        if (col < row) {
            if (arr[col] > arr[col + 1]) {
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }

            bubbleSort(arr, row, col + 1);
        } else {
            // Start next pass
            bubbleSort(arr, row - 1, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        bubbleSort(arr, arr.length - 1, 0);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
