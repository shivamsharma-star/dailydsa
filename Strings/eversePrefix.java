class Solution {
    public String reversePrefix(String word, char ch) {

        int index = word.indexOf(ch);

        if (index == -1) {
            return word;
        }

        StringBuilder sb = new StringBuilder(word);

        int left = 0;
        int right = index;

        while (left < right) {

            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);

            left++;
            right--;
        }

        return sb.toString();
    }
}