public class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][][] memo;
    private int m, n;
    private int[][] grid;

    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        
        this.memo = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        
        long totalPaths = 0;
        totalPaths = (totalPaths + dfs(0, 0, 0)) % MOD; 
        totalPaths = (totalPaths + dfs(0, 0, 1)) % MOD; 
        
        return (int) totalPaths;
    }

    private int dfs(int i, int j, int dir) {
        int ni = i + (dir == 1 ? 1 : 0);
        int nj = j + (dir == 0 ? 1 : 0);
        if (ni >= m || nj >= n) {
            return 0;
        }
        while (ni < m && nj < n && grid[ni][nj] == 1) {
            if (dir == 0) {
                dir = 1;
                ni += 1;
            } else {
                dir = 0;
                nj += 1;
            }
        }
        
        if (ni >= m || nj >= n) {
            return 0;
        }
        
        if (ni == m - 1 && nj == n - 1) {
            return 1;
        }
        
        if (memo[ni][nj][dir] != -1) {
            return memo[ni][nj][dir];
        }
        
        long paths = 0;
        paths = (paths + dfs(ni, nj, 0)) % MOD;
        paths = (paths + dfs(ni, nj, 1)) % MOD;
        
        return memo[ni][nj][dir] = (int) paths;
    }
}