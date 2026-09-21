public class Solution {
    // This problem asks us to find the count of all subarrays whose product is divisible by k.
    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];

        
       
        long[] dp = new long[k];

        for (int num : nums) {

            long[] newDp = new long[k];

            int mod = num % k;

            
            newDp[mod] = 1;

          
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