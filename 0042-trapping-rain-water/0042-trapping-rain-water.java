class Solution {
    public int trap(int[] height) {
        
        int n= height.length;
        
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        for (int i=1; i < height.length; i++ ) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[n-1] = height[n-1];

        for (int i=n-2; i > -1; i-- ) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int result = 0;

        for (int i=1; i < height.length; i++ ) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return result;

    }
}