public import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {

        HashMap<Integer, Integer> count = new HashMap<>();

        // Har size-k subarray
        for (int i = 0; i <= nums.length - k; i++) {

            // Current window ke elements
            HashSet<Integer> seen = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                seen.add(nums[j]);
            }

            // Har unique element ka window count badhao
            for (int num : seen) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
        }

        int answer = -1;

        // Jo exactly 1 window mein aaya
        for (int num : count.keySet()) {
            if (count.get(num) == 1) {
                answer = Math.max(answer, num);
            }
        }

        return answer;
    }
} {
    
}
