class Solution {
    public String smallestSubsequence(String s) {
        
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++ ) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        boolean[] visited = new boolean[26];

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++ ) {

            char curr = s.charAt(i);
            if (!visited[curr - 'a']) {
                while (!stack.isEmpty() &&
                    stack.peek() > curr &&
                    lastIndex[stack.peek() - 'a'] > i) {
                        
                        visited[stack.pop() - 'a'] = false;
                        
                }

                stack.push(curr);
                visited[curr - 'a'] = true;
            }
        }
        String result = "";
        for (char ch: stack) result += ch;

        return result;

    }
}