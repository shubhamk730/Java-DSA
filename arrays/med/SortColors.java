package arrays.med;

public class SortColors {

    public static void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;

        while(j <= k) {
            if(nums[j] == 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[j] = temp;
                i++;
                j++;
            }
            else if( nums[j] == 2) {
                int temp = nums[k];
                nums[k] = 2;
                nums[j] = temp;
                k--;
            } else {
                j++;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1,1,0,0,0,0,1,2,2,1,2,1,0,1,1,2,2, 2, 0};

        sortColors(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }


}
