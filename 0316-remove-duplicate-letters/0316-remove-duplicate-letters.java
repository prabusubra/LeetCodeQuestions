import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        // Track the last occurrence of each character
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Use a stack to build the result
        Stack<Character> stack = new Stack<>();
        // Visited array to track if a character is in the stack
        boolean[] visited = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If the character is already in the stack, skip it
            if (visited[ch - 'a']) continue;

            // Remove characters from the stack that are:
            // - greater than the current character
            // - can appear later (i.e., their last occurrence is after the current index)
            while (!stack.isEmpty() && stack.peek() > ch && lastIndex[stack.peek() - 'a'] > i) {
                visited[stack.pop() - 'a'] = false;
            }

            // Push the current character onto the stack
            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        // Build the result from the stack
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}
