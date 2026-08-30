public class Solution {
    public String reverseVowels(String s) {
        char[] st = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        // Step 1: push all vowels
        for (char c : st) {
            if (isVowel(c)) {
                stack.push(c);
            }
        }

        // Step 2: replace vowels in reverse order
        for (int i = 0; i < st.length; i++) {
            if (isVowel(st[i])) {
                st[i] = stack.pop();
            }
        }

        return new String(st);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
} {
    
}
