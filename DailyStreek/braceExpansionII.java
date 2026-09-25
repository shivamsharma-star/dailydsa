import java.util.*;

class Solution {

    private int index = 0;

    public List<String> braceExpansionII(String expression) {

        Set<String> result = parseUnion(expression);

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

   
    private Set<String> parseUnion(String s) {

        Set<String> result = new HashSet<>();

        while (index < s.length() && s.charAt(index) != '}') {

            Set<String> current = parseConcat(s);

            result.addAll(current);

            if (index < s.length() && s.charAt(index) == ',') {
                index++;   
            } else {
                break;
            }
        }

        return result;
    }

    // Handles: abc, a{b,c}d, {a,b}{c,d}
    private Set<String> parseConcat(String s) {

        Set<String> result = new HashSet<>();
        result.add("");

        while (index < s.length()) {

            char c = s.charAt(index);

            // Stop concatenation
            if (c == ',' || c == '}') {
                break;
            }

            Set<String> next;

            if (c == '{') {

                index++;                 // skip '{'
                next = parseUnion(s);
                index++;                 // skip '}'

            } else {

                // Single character
                index++;

                next = new HashSet<>();
                next.add(String.valueOf(c));
            }

            // Cartesian product
            Set<String> temp = new HashSet<>();

            for (String a : result) {
                for (String b : next) {
                    temp.add(a + b);
                }
            }

            result = temp;
        }

        return result;
    }
}