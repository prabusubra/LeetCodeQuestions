class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
         final int MOD = 1000000007;

        // Initialize dp array with size high+1
        long[] dp = new long[high + 1];
        dp[0] = 1; // There's one way to create a string of length 0 (the empty string)

        // Fill dp array for lengths from 1 to high
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] += dp[i - zero];
            }
            if (i >= one) {
                dp[i] += dp[i - one];
            }
            dp[i] %= MOD; // Take modulo at each step
        }

        // Sum the values of dp[i] for i in range [low, high]
        long result = 0;
        for (int i = low; i <= high; i++) {
            result += dp[i];
            result %= MOD;
        }

        return (int) result;
    }
}