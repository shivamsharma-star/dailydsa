class Solution {
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();

        for (char c : s.toCharArray()) {

            // Opening bracket
            if (c == '[' || c == '(' || c == '{') {
                myStack.push(c);
            }

            // Closing bracket
            else {
                if (myStack.isEmpty()) {
                    return false;
                }

                char k = myStack.peek();

                if ((c == ']' && k == '[') ||
                    (c == ')' && k == '(') ||
                    (c == '}' && k == '{')) {

                    myStack.pop();
                } else {
                    return false;
                }
            }
        }

        return myStack.isEmpty();
    }
}