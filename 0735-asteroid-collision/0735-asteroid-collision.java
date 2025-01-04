class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Deque<Integer> stack = new ArrayDeque<>();

        for (int ast: asteroids) {

            boolean destroyed = false;

            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {

                int top = stack.peek();

                int absTop = Math.abs(top);

                int absAst = Math.abs(ast);

                if (absTop < absAst) {
                    stack.pop();
                } else if (absTop > absAst) {
                    destroyed = true;
                    break;
                } else {
                    stack.pop();
                    destroyed = true;
                    break;
                }


            }

            if (!destroyed) stack.push(ast);

        }

        int[] result = new int[stack.size()];

        for (int i = result.length -1; i >= 0; i-- ) {
            result[i] = stack.pop();
        }

        return result;

    }
}