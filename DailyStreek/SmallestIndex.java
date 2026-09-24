class Solution {
    public int smallestIndex(int[] nums) {
// iterate through the array to find the smallest index where the sum of digits equals the index
        for (int i = 0; i < nums.length; i++) {

            int n = nums[i];
            int sum = 0;
// calculate the sum of digits of the number
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
// check if the sum of digits equals the index
            if (sum == i) {
                return i;
            }
        }
// return -1 if no index found
        return -1;
    }
}