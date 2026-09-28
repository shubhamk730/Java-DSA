package arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    
    public static List<Integer> majorityElementTwo(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        int cnt1 = 0, cnt2 = 0, ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            if(cnt1 == 0 && nums[i] != ele2) {
                cnt1++;
                ele1 = nums[i];
            } 
            else if(cnt2 == 0 && nums[i] != ele1) {
                cnt2++;
                ele2 = nums[i];
            }
            else if (nums[i] == ele1) {
                cnt1++;
            } 
            else if(nums[i] == ele2) {
                cnt2++;
            } 
            else {
                cnt1--;
                cnt2--;
            }
        }

        int ccnt1 = 0, ccnt2 = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == ele1) ccnt1++;
            else if(nums[i] == ele2) ccnt2++;
        }

        if(ccnt1 > n/3) ans.add(ele1);
        if(ccnt2 > n/3) ans.add(ele2);


        return ans;
    }


    public static void main(String[] args) {
        List<Integer> ans = majorityElementTwo(new int[]{1, 2, 1, 1, 3, 2, 2});
        System.out.println(ans);
    
    }

}
