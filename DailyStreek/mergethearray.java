public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p = m - 1;          // nums1 ke actual elements ka last index
        int q = n - 1;          // nums2 ka last index
        int i = m + n - 1;      // final array ka last index

        while (p >= 0 && q >= 0) {

            if (nums1[p] > nums2[q]) {
                nums1[i] = nums1[p];
                p--;
            } else {
                nums1[i] = nums2[q];
                q--;
            }

            i--;
        }

        // Agar nums2 mein elements bach gaye
        while (q >= 0) {
            nums1[i] = nums2[q];
            q--;
            i--;
        }
    }
} {
    
}
