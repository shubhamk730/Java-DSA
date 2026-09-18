package arrays.med;

import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;

        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }

        if(index == -1) {
            Arrays.sort(nums);
            return;
        }

        int num = nums[index];
        int nextGreater = Integer.MAX_VALUE;
        int nextGI = -1;

        for(int i = n - 1; i > index; i--) {
            if(nums[i] > num && nums[i] < nextGreater) {
                nextGI = i;
                nextGreater = nums[i];
                break;
            }
        }

        int temp = nums[index];
        nums[index] = nums[nextGI];
        nums[nextGI] = temp;
        // sort the last part or reverse it as it is already sorted in reverse order
        Arrays.sort(nums, index + 1, n);
        return;
    }
    
    public static void main(String[] args) {
        
    }

}
