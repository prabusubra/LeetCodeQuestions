class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();

        for (String token: tokens) {

            if ("+-*/".contains(token)) {

                int one = stack.pop();
                int sec = stack.pop();

                stack.push(applyOperation(token, sec, one));

            } else {
                stack.push(Integer.valueOf(token));
            }

        }

        return stack.pop();
    }

    private static int applyOperation(String operator, int a, int b) {

        switch (operator) {
            case "+" : return a + b;
            case "-" : return a - b;
            case "*" : return a * b;
            case "/" : return a / b;
            default: throw new IllegalArgumentException("Invalid Operator");
        }

    }
}