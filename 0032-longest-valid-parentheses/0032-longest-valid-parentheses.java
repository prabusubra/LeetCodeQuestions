class Solution {
    public int longestValidParentheses(String s) {

        int right = 0, left = 0, maxLen = 0;

        for (char ch: s.toCharArray()) {
            if (ch == '(') left++;
            else right++;

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (right > left){
                left = right = 0;
            }
        }

        left = right = 0;

        for (int i = s.length()-1; i >=0; i-- ) {
            char ch = s.charAt(i);

            if (ch == '(') left++;
            else right++;

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }

        }
        return maxLen;
    }
}