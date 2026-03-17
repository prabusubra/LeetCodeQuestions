public class Solution {
    public int climbStairs(int n) {
        
        int s1 = 1;
        int s2 = 2;

        int result = n == 2 ? 2 : n== 1?1:0;
        for (int i=3; i <= n; i++ ) {
            result = s1 + s2;
            s1 = s2;
            s2 = result;
        }

        return result;

    }
}