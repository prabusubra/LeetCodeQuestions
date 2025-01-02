class Solution {
    public String removeStars(String s) {
        
        Stack<Character> stack = new Stack<>();
        for (char curr: s.toCharArray()) {
            
            if (curr == '*' && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(curr);
            }
            
        }

        String result = "";

        for (char ch: stack) result += ch;

        return result;

    }
}