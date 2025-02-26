class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<>();
        int result=0, n = heights.length;


        for (int i = 0; i <= n; i++ ) {
            int curr = i==n ? 0 : heights[i];
            
            while (!stack.isEmpty() && heights[stack.peek()] > curr) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek()-1;
                result = Math.max(result, h*w);
            }

            stack.push(i);
        }

        return result;
    }
}