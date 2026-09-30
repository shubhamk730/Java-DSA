package arrays.hard;

class Solution {
    public int maxProduct(int[] nums) {
        int prod = Integer.MIN_VALUE;

        int pre = 1, suff = 1;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(pre == 0) pre = 1;
            if(suff == 0) suff = 1;

            pre = pre*nums[i];
            suff = suff * nums[n-1-i];

            prod = Math.max(Math.max(pre, suff), prod);
        }

        return prod;

    }
}

public class MaxProdSubarray {

    public static void main(String[] args) {
        
    }
}
