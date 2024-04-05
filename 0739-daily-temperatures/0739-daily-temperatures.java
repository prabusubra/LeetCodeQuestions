class Solution {
    public int[] dailyTemperatures(int[] temp) {
      Stack<Integer> stack = new Stack<>();
      int[] ans = new int[temp.length];

      for (int i=0; i < temp.length;i++){
        if (stack.isEmpty()){
            stack.push(0);
        } else {
            if (temp[i] < temp[stack.peek()]){
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temp[i] > temp[stack.peek()]){
                    int tmpPeekIndex = stack.pop();
                    ans[tmpPeekIndex] = i - tmpPeekIndex;
                    ;
                }
                stack.push(i);
            }
        }
      }
      return ans;

    }
}