class Solution {

    int m, n;
    char[][] grid;
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        
        if ((m + n - 1) % 2 == 1) {
            return false;
        }

    
        if (grid[0][0] == ')') {
            return false;
        }

        // Last must be ')'
        if (grid[m - 1][n - 1] == '(') {
            return false;
        }

        dp = new Boolean[m][n][m + n];

        return dfs(0, 0, 0);
    }

    private boolean dfs(int i, int j, int balance) {

        // Current bracket
        if (grid[i][j] == '(') {
            balance++;
        } else {
            balance--;
        }

        // Invalid prefix
        if (balance < 0) {
            return false;
        }

        // Reached destination
        if (i == m - 1 && j == n - 1) {
            return balance == 0;
        }

        // Already calculated
        if (dp[i][j][balance] != null) {
            return dp[i][j][balance];
        }

        boolean down = false;
        boolean right = false;

        // Move down
        if (i + 1 < m) {
            down = dfs(i + 1, j, balance);
        }

        // Move right
        if (j + 1 < n) {
            right = dfs(i, j + 1, balance);
        }

        return dp[i][j][balance] = down || right;
    }
}