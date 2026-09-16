class Solution {
    // function to calculate the maximum number of non-overlapping palindromic substrings of length at least k
    public int numberOfSets(int n, int k) {
//  long MOD = 1000000007L;
        long MOD = 1000000007L;

        long[] dp = new long[2 * k + 1];
        dp[0] = 1;
//  for each point from 1 to n + k - 1, update the dp array to count the number of ways to choose segments
        for (int i = 1; i <= n + k - 1; i++) {

            for (int j = Math.min(i, 2 * k); j >= 1; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }
//  return the number of ways to choose k non-overlapping segments from n points
        return (int) dp[2 * k];
    }
}