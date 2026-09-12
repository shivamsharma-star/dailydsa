import java.util.*;

class Solution {

    static class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    static class State {
        long score;
        int[] ids;

        State(long score, int[] ids) {
            this.score = score;
            this.ids = ids;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        Interval[] arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        // Sort by starting point
        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l)
                return Integer.compare(a.l, b.l);

            return Integer.compare(a.r, b.r);
        });

        State[][] dp = new State[n + 1][5];

        // BASE CASE
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new State(0, new int[0]);
            }
        }

        // DP
        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {

                // 1. Don't take current interval
                State skip = dp[i + 1][k];

                // 2. Take current interval
                int next = findNext(arr, i + 1, arr[i].r);

                State nextState = dp[next][k - 1];

                int[] newIds = new int[nextState.ids.length + 1];

                for (int j = 0; j < nextState.ids.length; j++) {
                    newIds[j] = nextState.ids[j];
                }

                newIds[nextState.ids.length] = arr[i].idx;

                // Lexicographical comparison ke liye sorted indices
                Arrays.sort(newIds);

                State take = new State(
                    arr[i].w + nextState.score,
                    newIds
                );

                // Compare
                if (take.score > skip.score) {
                    dp[i][k] = take;
                }
                else if (take.score < skip.score) {
                    dp[i][k] = skip;
                }
                else {
                    if (compare(take.ids, skip.ids) < 0) {
                        dp[i][k] = take;
                    }
                    else {
                        dp[i][k] = skip;
                    }
                }
            }
        }

        return dp[0][4].ids;
    }

    private int findNext(Interval[] arr, int start, int end) {

        int left = start;
        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Non-overlap:
            // current end < next start
            if (arr[mid].l > end) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int compare(int[] a, int[] b) {

        int n = Math.min(a.length, b.length);

        for (int i = 0; i < n; i++) {

            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }
// return statememnt for comparing lengths of arrays if all elements are equal


        return Integer.compare(a.length, b.length);
    }
}    