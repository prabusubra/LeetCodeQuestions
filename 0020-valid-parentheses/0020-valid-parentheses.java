class Solution {
    public boolean isValid(String s) {
        
        Deque<Character> stack = new ArrayDeque<>();

        for (char curr: s.toCharArray()) {
            if (curr == '(') stack.push(')');
            else if (curr == '{') stack.push('}');
            else if (curr == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != curr) 
                return false;
        }

        return stack.isEmpty();
    }
}