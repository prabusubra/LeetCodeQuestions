class Solution {
    public int longestValidParentheses(String s) {
        
        if (s.length() < 2) return 0;

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(-1);

        int maxLen = 0;

        for (int i =0 ; i < s.length(); i++ ) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}