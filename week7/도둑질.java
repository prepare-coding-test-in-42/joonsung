import java.util.*;

class Solution {
    final int FIRST = 0;
    final int LAST = 1;
    
    public int solution(int[] money) {
        // dp: i번째 집까지 했을 때의 최대 수탈 금액
        // FIRST: 첫번째O 마지막X인 경우
        // LAST: 첫번째X 마지막O인 경우
        int n = money.length;
        int[][] dp = new int[2][n];
        
        dp[FIRST][0] = money[0];
        dp[FIRST][1] = money[0];
        dp[LAST][0] = 0;
        dp[LAST][1] = money[1];
        
        for (int i = 2; i < n; i++) {
            for (int j = FIRST; j <= LAST; j++)
                dp[j][i] = Math.max(dp[j][i - 1], dp[j][i - 2] + money[i]);
        }
        
        return Math.max(dp[FIRST][n - 2], dp[LAST][n - 1]);
    }
}
