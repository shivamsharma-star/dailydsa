class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
//  if the total sum of the array is less than x, it's impossible to reduce x to zero, so return -1.

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        if (target < 0) {
            return -1;
        }

        if (target == 0) {
            return n;
        }
//  Use a sliding window approach to find the longest subarray that sums to target. The idea is to maintain a window of elements and adjust its size based on the current sum compared to the target. If the current sum exceeds the target, we shrink the window from the left. If it matches the target, we update the maximum length found so far. Finally, we return the minimum number of operations needed to reduce x to zero, which is the total length minus the length of the longest subarray that sums to target. If no such subarray exists, we return -1.
        int left = 0;
        int sum = 0;
        int maxLen = -1;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum > target && left <= right) {
                sum -= nums[left++];
            }

            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
// return the minimum number of operations to reduce x to zero, which is the total length minus the length of the longest subarray that sums to target. If no such subarray exists, return -1.
        return maxLen == -1 ? -1 : n - maxLen;
    }
}