class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

              int p1 = m - 1; // Last index of nums1's non-placeholder elements
        int p2 = n - 1; // Last index of nums2
        int p = m + n - 1; // Last index of nums1

        // Compare from the end of both arrays
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // Copy remaining elements from nums2, if any
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }  

    }
}