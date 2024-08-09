class Solution {
    public int maxArea(int[] height) {
        int n = height.length-1;
        int left = 0;
        int right = n;
        int rs = 0;
        
        
        while (left < right){
            
            int width = right-left;
            
            int cap = Math.min(height[right], height[left]);
            
            cap*=width;
            
            rs = Math.max(cap, rs);
            
            if (height[left] < height[right]) left++;
            else right--;
        }
        return rs;
    }
}