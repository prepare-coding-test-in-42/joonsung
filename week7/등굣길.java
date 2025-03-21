class Solution {
    final int QUOT = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        dp[1][1] = 1;
        
        for (int[] puddle: puddles) {
            dp[puddle[0]][puddle[1]] = -1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % QUOT;
            }
        }
        
        return dp[m][n];
    }
}
