class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int num: nums ){
            sum =sum+num;
        }

        int sum2 = n*(n+1)/2;
        int missing = sum2-sum;
        return missing;
    }
}