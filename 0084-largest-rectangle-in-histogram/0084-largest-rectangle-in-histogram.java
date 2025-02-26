class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        int maxArea=0;

        while (current < heights.length){
            while (!stack.isEmpty() && heights[current] < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty()? current: current - stack.peek() - 1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(current++);
        }

        while (!stack.isEmpty()){
            int height = heights[stack.pop()];
            int width = stack.isEmpty()? heights.length: heights.length - stack.peek() - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;

    }
    
}

