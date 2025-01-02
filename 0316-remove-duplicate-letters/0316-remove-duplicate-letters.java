import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] lastIndex = new int[26];

        for (int i=0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();

        boolean[] visited = new boolean[26];

        for (int i=0; i < s.length(); i++) {
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

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.reverse().toString();
    }
}
