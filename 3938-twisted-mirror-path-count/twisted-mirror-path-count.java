class Solution {
    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int mod = 1000000007;

        int[][] right = new int[m][n];
        int[][] down = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(right[i], -1);
            Arrays.fill(down[i], -1);
        }
        // Precompute mirror movements
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (grid[i][j] == 0) {
                    right[i][j] = i * n + j;
                    down[i][j] = i * n + j;
                } 
                else {
                    if (i + 1 < m) {
                        right[i][j] = down[i + 1][j];
                    }

                    if (j + 1 < n) {
                        down[i][j] = right[i][j + 1];
                    }
                }
            }
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        // Count valid paths
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 || dp[i][j] == 0) {
                    continue;
                }
                int ways = dp[i][j];
                // Move right
                if (j + 1 < n && right[i][j + 1] != -1) {
                    int pos = right[i][j + 1];
                    int x = pos / n;
                    int y = pos % n;
                    dp[x][y] = (dp[x][y] + ways) % mod;
                }
                // Move down
                if (i + 1 < m && down[i + 1][j] != -1) {

                    int pos = down[i + 1][j];
                    int x = pos / n;
                    int y = pos % n;
                    dp[x][y]=(dp[x][y] + ways) % mod;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}