class Solution {
    public int reverseDegree(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // reverse alphabet value: a=26, b=25, ..., z=1
            int value = 'z' - c + 1;

            // position is 1-indexed
            int position = i + 1;

            sum += value * position;
        }

        return sum;
    }
}