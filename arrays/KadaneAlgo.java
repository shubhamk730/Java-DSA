package arrays;

public class KadaneAlgo {
    
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxValue = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            sum += nums[i];

            if(sum > maxValue) maxValue = sum;

            if(sum < 0) sum = 0;
        }

        if(maxValue < 0) maxValue = 0;

        return maxValue;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        maxSubArray(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
