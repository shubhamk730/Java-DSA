package arrays.hard;

//Merge 2 sorted arrays without extra space
/* 
1.Approach 1 is take a pointer at last element in array 1 and take a pointer at first element in array 2.
2. Swap these if left is greater than right, then left-- right++
3. keep swapping till i > 0 and j < m or till you condition is false because then all further will be false.
4. sort both arrays individually and return the answer.
*/

class MASolution {
    private void swap(int[] nums1, int n, int[] nums2, int m) {
        int temp = nums1[n];
        nums1[n] = nums2[m];
        nums2[m] = temp;
    }

    public void merge(int[] nums1, int n, int[] nums2, int m) {
        int len = n+m;
        int gap = (len/2) + len%2;

        while(gap > 0) {
            int l = 0;
            int r = l + gap;
            while(r < len) {
                // l in arr1 and r in arr2
                if(l < n && r >= n) {
                    if(nums1[l] > nums2[r-n]) {
                        swap(nums1,l,nums2, r-n);
                    }
                } 

                // l in arr2 and r in arr2
                else if (l >= n && r >= n) {
                    if(nums2[l-n] > nums2[r-n]) {
                        swap(nums2,l-n,nums2, r-n);
                    }
                }

                // l in arr1 and r in arr1
                else {
                    if(nums1[l] > nums1[r]) {
                        swap(nums1,l,nums1, r);
                    }
                }
                l++;
                r++;
            }
            if(gap == 1) break;
            gap = gap/2 + gap%2;

        }

    }
}

public class MergeArrays {

    public static void main(String[] args) {
        
    }
    
}
