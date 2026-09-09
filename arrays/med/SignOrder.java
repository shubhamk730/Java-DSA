package arrays.med;

public class SignOrder {

     public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int pi = 0;
        int ni = 1;

        for(int i = 0; i < n; i++) {
            if(nums[i] >= 0) {
                ans[pi] = nums[i];
                pi += 2;
            } else {
                ans[ni] = nums[i];
                ni += 2;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};

        int ans[] = new int[6];
        ans = rearrangeArray(arr);

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
