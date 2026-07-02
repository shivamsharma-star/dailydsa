class InsertionSort {
    public static void main(String[] args) {

        int[] nums = {14,554,55,241,22,21,25,26,25,24,2,25,25,12,52,1,25,25};

        for (int i = 1; i < nums.length; i++) {

            int key = nums[i];
            int j = i - 1;

            // Shift larger elements to the right
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }

            // Insert key at correct position
            nums[j + 1] = key;
        }

        // Print sorted array
        for (int num : nums) {
            System.out.println(num);
        }
    }
}