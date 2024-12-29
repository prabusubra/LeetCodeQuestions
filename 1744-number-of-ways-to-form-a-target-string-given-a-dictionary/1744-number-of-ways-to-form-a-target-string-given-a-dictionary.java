class Solution {
    public int numWays(String[] words, String target) {
         int mod = 1_000_000_007;
        int n = words[0].length(); // Number of columns in words
        int m = target.length();  // Length of target

        // Precompute frequency of characters in each column
        int[][] frequency = new int[n][26];
        for (String word : words) {
            for (int j = 0; j < n; j++) {
                frequency[j][word.charAt(j) - 'a']++;
            }
        }

        // DP array: dp[i][j] represents ways to form target[i:] using columns j to n-1
        long[][] dp = new long[m + 1][n + 1];
        for (long[] row : dp) {
            Arrays.fill(row, -1); // Fill with -1 to indicate uncomputed states
        }

        return (int) countWays(0, 0, target, frequency, dp, mod);
    }
        private long countWays(int i, int j, String target, int[][] frequency, long[][] dp, int mod) {
        // Base cases
        if (i == target.length()) return 1; // Successfully formed the target
        if (j == frequency.length) return 0; // Exhausted columns but target not formed

        // If already computed, return the stored result
        if (dp[i][j] != -1) return dp[i][j];

        // Skip current column
        long ways = countWays(i, j + 1, target, frequency, dp, mod);

        // Use current column if possible
        char currentChar = target.charAt(i);
        if (frequency[j][currentChar - 'a'] > 0) {
            ways += (frequency[j][currentChar - 'a'] * countWays(i + 1, j + 1, target, frequency, dp, mod)) % mod;
        }

        // Store the result in dp table
        dp[i][j] = ways % mod;
        return dp[i][j];
    }
}