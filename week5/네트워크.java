import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            
            visited[i] = true;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int j = 0; j < n; j++) {
                    if (visited[j])
                        continue;
                    if (computers[cur][j] == 1) {
                        visited[j] = true;
                        q.add(j);
                    }
                }
            }

            answer++;
        }
        
        return answer;
    }
}
