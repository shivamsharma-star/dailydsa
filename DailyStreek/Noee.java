class Solution {

    class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            cnt = new int[k];
        }
    }

    int k;
    Node[] tree;

 
    void build(int node, int l, int r, int[] nums) {

        if (l == r) {
            int val = nums[l] % k;

            tree[node].prod = val;
            tree[node].cnt[val] = 1;

            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        merge(node);
    }

   
    void merge(int node) {

        Node left = tree[node * 2];
        Node right = tree[node * 2 + 1];
        Node cur = tree[node];

        for (int i = 0; i < k; i++) {
            cur.cnt[i] = 0;
        }

       
        cur.prod = (left.prod * right.prod) % k;

        for (int rem = 0; rem < k; rem++) {

          
            cur.cnt[rem] += left.cnt[rem];

        
            int newRem = (left.prod * rem) % k;

            cur.cnt[newRem] += right.cnt[rem];
        }
    }

    
    void update(int node, int l, int r, int index, int value) {

        if (l == r) {

            value %= k;

            tree[node].prod = value;

            for (int i = 0; i < k; i++) {
                tree[node].cnt[i] = 0;
            }

            tree[node].cnt[value] = 1;

            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }

        merge(node);
    }

    // ---------------- QUERY ----------------
    Node query(int node, int l, int r, int ql, int qr) {

        // Complete range
        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = (l + r) / 2;

        // Only left
        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }

        // Only right
        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        }

        // Both sides
        Node left = query(node * 2, l, mid, ql, qr);
        Node right = query(node * 2 + 1, mid + 1, r, ql, qr);

        return combine(left, right);
    }

    // ---------------- COMBINE QUERY RESULTS ----------------
    Node combine(Node left, Node right) {

        Node res = new Node(k);

        res.prod = (left.prod * right.prod) % k;

        for (int rem = 0; rem < k; rem++) {

            // Prefix completely in left
            res.cnt[rem] += left.cnt[rem];

            // Prefix starts in right
            int newRem = (left.prod * rem) % k;

            res.cnt[newRem] += right.cnt[rem];
        }

        return res;
    }

    // ---------------- MAIN ----------------
    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.k = k;

        int n = nums.length;

        tree = new Node[4 * n];

        
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node(k);
        }

       
        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, index, value);

            
            Node result = query(1, 0, n - 1, start, n - 1);

          
            ans[i] = result.cnt[x];
        }

        return ans;
    }
}