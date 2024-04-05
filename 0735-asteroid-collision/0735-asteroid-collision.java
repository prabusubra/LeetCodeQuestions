class Solution {
    public int[] asteroidCollision(int[] ast) {
        Stack<Integer> s = new Stack<>();
        for (int i=0;i<ast.length;i++){
            if (ast[i] > 0){
                s.push(ast[i]);
            } else {
                while (!s.isEmpty() && s.peek() >0 && s.peek() < Math.abs(ast[i])){
                    s.pop();
                }
                if (s.isEmpty() || s.peek() < 0){
                    s.push(ast[i]);
                } else if (s.peek() == Math.abs(ast[i])){
                    s.pop();
                }
            }

        }
        int[] ans = new int[s.size()];
        for (int i =ans.length-1;i>=0;i--){
            ans[i] = s.pop();
        }
        return ans;
    }
}