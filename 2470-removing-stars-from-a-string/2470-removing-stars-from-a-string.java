class Solution {
    public String removeStars(String s) {
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++ ) {
            char curr = s.charAt(i);

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