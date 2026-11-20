package DynamicProgramming;

//
public class UniquePathWithObstacles {
    public int paths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = (grid[0][0] == 0) ? 1 : 0;

        for (int i = 1; i < m; i++) {
            dp[i][0] = (grid[i][0] == 0) ? dp[i - 1][0] : 0;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = (grid[0][j] == 0) ? dp[0][j - 1] : 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (grid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathWithObstacles obj = new UniquePathWithObstacles();
        int[][] grid = {
                {0, 0, 1, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 1, 0}
        };
        System.out.println(obj.paths(grid));
    }
}
