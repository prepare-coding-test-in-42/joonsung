import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e: edge) {
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n + 1]; // 1번 노드로부터 각 노드까지의 거리
        Arrays.fill(dist, -1);
        
        q.add(1);
        dist[1] = 0;
        int maxDist = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next: graph.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    maxDist = Math.max(maxDist, dist[next]);
                    q.add(next);
                }
            }
        }
        
        int cnt = 0;
        
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxDist)
                cnt++;
        }
        
        return cnt;
    }
}
