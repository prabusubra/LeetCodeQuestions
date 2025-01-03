class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] result = new int[nums1.length];
        for (int i =0; i < nums1.length; i++ ) {
            int index = getIndex(nums2, nums1[i]);
            result[i] = findRightMax(nums2, index);
        }
        return result;
    }

    private static int getIndex(int[] arr, int data) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) return i;
        }

        return 0;
    }

    private static int findRightMax(int[] arr, int start) {
        
        int result = -1;
        for (int i = start +1; i < arr.length; i++ ) {
            
            if (arr[i] > arr[start]) {
                result = arr[i];
                break;
            }

        }

        return result;
    }
}