class Solution {
    public int calculate(String s) {
        
        Stack<Integer> stack = new Stack<>();

        int curr = 0, resp = 0, sign = 1;

        for (char ch: s.toCharArray()) {

            if (Character.isDigit(ch)) {

                curr = curr*10 + (int)ch - '0';

            } else if (ch == '+' || ch == '-') {
                resp += curr * sign;
                curr = 0;
                sign = ch == '+' ? 1 : -1;
            } else if (ch == '(') {
                stack.push(resp);
                stack.push(sign);
                resp = 0;
                sign = 1;
            } else if (ch == ')') {

                resp += curr * sign;

                resp *= stack.pop();
                resp += stack.pop();

                curr = 0;
            }

        }

        return resp + curr * sign;

    }
}