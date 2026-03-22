class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] smaller = nums1.length < nums2.length ? nums1 : nums2;
        int[] larger = nums1.length < nums2.length ? nums2 : nums1;

        int total = nums1.length + nums2.length;

        int left = 0, right = smaller.length;

        while (left <= right) {

            int lp = (left+right)/2;
            int rp = ((total + 1)/2) - lp;

            int l1 = lp == 0 ? Integer.MIN_VALUE : smaller[lp-1];
            int r1 = lp == smaller.length? Integer.MAX_VALUE : smaller[lp];

            int l2 = rp == 0 ? Integer.MIN_VALUE : larger[rp - 1];
            int r2 = rp == larger.length ? Integer.MAX_VALUE : larger[rp];


            if (l1 <= r2 && l2 <= r1) {

                //valid partition

                if (total % 2 == 0) 
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0; //it has to be float
                else return Math.max(l1, l2);

            } else if (l1 > r2) right = lp -1;
            else left = lp+1;
        }

        return 0;
    }
}