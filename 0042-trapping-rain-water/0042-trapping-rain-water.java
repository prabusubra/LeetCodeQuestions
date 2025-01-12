class Solution {
    public int trap(int[] height) {
        
        int n= height.length;
        
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        for (int i=1; i < height.length; i++ ) {
            if (leftMax[i-1] > height[i]) leftMax[i] = leftMax[i-1];
            else leftMax[i] = height[i];
        }

        rightMax[n-1] = height[n-1];

        for (int i=n-2; i > -1; i-- ) {
            if (rightMax[i+1] > height[i]) rightMax[i] = rightMax[i+1];
            else rightMax[i] = height[i];
        }

        int result = 0;

        for (int i=1; i < height.length; i++ ) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return result;

    }
}