import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 1];
        
        Arrays.fill(clothes, 1);
        
        for (int l: lost)
            clothes[l]--;
        
        for (int r: reserve)
            clothes[r]++;
        
        for (int i = 1; i <= n; i++) {
            if (clothes[i] == 0) {
                if (i > 1 && clothes[i - 1] > 1) {
                    clothes[i - 1]--;
                    clothes[i]++;
                }     
                else if (i < n && clothes[i + 1] > 1) {
                    clothes[i + 1]--;
                    clothes[i]++;
                }
            }
        }
        
        int answer = 0;
        for (int c: clothes) {
            if (c > 0)
                answer++;
        }
        
        return answer - 1;
    }
}
