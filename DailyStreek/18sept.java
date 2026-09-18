class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        // first occurrence ko -1 se initialize
        Arrays.fill(first, -1);

        // first and last occurrence
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            if (first[c] == -1) {
                first[c] = i;
            }

            last[c] = i;
        }

        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        // String ko left se right scan karo
        for (int i = 0; i < n; i++) {

            // Sirf first occurrence se substring start karenge
            if (first[s.charAt(i) - 'a'] != i) {
                continue;
            }

            int l = i;
            int r = last[s.charAt(i) - 'a'];

            boolean valid = true;

            // interval expand karo
            for (int j = l; j <= r; j++) {

                int c = s.charAt(j) - 'a';

                // Is character ki occurrence left side me hai
                if (first[c] < l) {
                    valid = false;
                    break;
                }

                // Is character ki last occurrence aur aage hai
                r = Math.max(r, last[c]);
            }

            if (valid) {

                // Previous substring se overlap ho raha hai
                if (l > prevEnd) {
                    ans.add(s.substring(l, r + 1));
                    prevEnd = r;
                } else {
                    
                    ans.set(ans.size() - 1, s.substring(l, r + 1));
                    prevEnd = r;
                }
            }
        }

        return ans;
    }
}