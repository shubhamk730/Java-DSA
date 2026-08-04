package sorting;


// select minimums and swap 
// put minimum at 0, then 1, then 2, ... till n-2 ( because last element will be sorted in itself)
// TC O(n^2)
public class SelectionSort {
    
    private static void sort(int[] arr){
        int n = arr.length;
        for(int i = 0; i <= n-2; i++) {
            int minidx = i;
            for(int j = i + 1; j < n; j++) {
                if(arr[j]< arr[minidx]) 
                    minidx = j;
            }

            int temp = arr[i];
            arr[i] = arr[minidx];
            arr[minidx] = temp;
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{123,32,54,1,5243,655,6};
        sort(arr);
        for(var el : arr) {
            System.out.print(el + " ");
        }
    }

}
