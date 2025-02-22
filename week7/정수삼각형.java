class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle[n - 1][j];
        }
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                int left = dp[i + 1][j];
                int right = dp[i + 1][j + 1];
                dp[i][j] = triangle[i][j] + Math.max(left, right);
            }
        }
        
        return dp[0][0];
    }
}
