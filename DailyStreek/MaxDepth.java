class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        //  mAX
        int maxDepth = 0;
// fyyydyydyd
        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (c == ')') {
                depth--;
            }
            // ddddd
        }
//  //#endregionkljlk
        return maxDepth;
    }
}