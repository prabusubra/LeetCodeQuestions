class Solution {
    public int trap(int[] height) {
        
        int n = height.length;

        int left = 0, right = n-1, leftMax = 0, rightMax = 0, trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                trappedWater += leftMax - height[left++];
            } else {
                rightMax = Math.max(height[right], rightMax);
                trappedWater += rightMax - height[right--];
            }
        }

        return trappedWater;

    }
}