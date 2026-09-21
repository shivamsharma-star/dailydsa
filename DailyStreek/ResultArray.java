public class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];

        // dp[r] = current ending subarrays
        // jinka product % k = r hai
        long[] dp = new long[k];

        for (int num : nums) {

            long[] newDp = new long[k];

            int mod = num % k;

            // Sirf current element se naya subarray
            newDp[mod] = 1;

            // Purane subarrays ko current num ke saath extend karo
            for (int r = 0; r < k; r++) {
                int newRemainder = (int)((1L * r * mod) % k);

                newDp[newRemainder] += dp[r];
            }

            
            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }

            dp = newDp;
        }

        return result;
    }
} 