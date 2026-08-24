import java.util.HashSet;

class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> mySet = new HashSet<>();

        for (int num : nums) {
            if (mySet.contains(num)) {
                mySet.remove(num);
            } else {
                mySet.add(num);
            }
        }

        return mySet.iterator().next();
    }
}     