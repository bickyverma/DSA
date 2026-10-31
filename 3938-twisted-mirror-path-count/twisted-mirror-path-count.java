import java.util.Arrays;

public class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][][] memo;
    private int m, n;
    private int[][] grid;

    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        
        // memo[i][j][dir]: 0 = coming from/going Right, 1 = coming from/going Down
        this.memo = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        
        // From start (0,0), the robot can initiate a move either Right or Down
        long totalPaths = 0;
        totalPaths = (totalPaths + dfs(0, 0, 0)) % MOD; // Try going Right
        totalPaths = (totalPaths + dfs(0, 0, 1)) % MOD; // Try going Down
        
        return (int) totalPaths;
    }

    private int dfs(int i, int j, int dir) {
        // Calculate the target cell based on intended movement direction
        int ni = i + (dir == 1 ? 1 : 0);
        int nj = j + (dir == 0 ? 1 : 0);
        
        // Out of boundaries check
        if (ni >= m || nj >= n) {
            return 0;
        }
        
        // Handle immediate reflections recursively until hitting an empty cell or boundary
        while (ni < m && nj < n && grid[ni][nj] == 1) {
            if (dir == 0) {
                // Moving right into a mirror -> reflected down
                dir = 1;
                ni += 1;
            } else {
                // Moving down into a mirror -> reflected right
                dir = 0;
                nj += 1;
            }
        }
        
        // Post-reflection boundary check
        if (ni >= m || nj >= n) {
            return 0;
        }
        
        // If we successfully arrived at the destination cell
        if (ni == m - 1 && nj == n - 1) {
            return 1;
        }
        
        // Standard Memoization check
        if (memo[ni][nj][dir] != -1) {
            return memo[ni][nj][dir];
        }
        
        // From the new empty cell (ni, nj), the robot can choose to proceed Right (0) or Down (1)
        long paths = 0;
        paths = (paths + dfs(ni, nj, 0)) % MOD;
        paths = (paths + dfs(ni, nj, 1)) % MOD;
        
        return memo[ni][nj][dir] = (int) paths;
    }
}