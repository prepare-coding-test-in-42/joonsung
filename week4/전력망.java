import java.util.*;

class Solution {
    int N;
    public int solution(int n, int[][] wires) {
        int answer = n;
        N = n;
        Arrays.sort(wires, (w1, w2) -> w1[0] - w2[0]);
        for (int i = 0; i < n - 1; i++) {
            int[][] cutNet = new int[n - 2][2];
            int idx = 0;
            for (int j = 0; j < n - 1; j++) {
                if (i != j)
                    cutNet[idx++] = wires[j];
            }
            
            int net1 = counter(wires[i][0], cutNet);
            int net2 = counter(wires[i][1], cutNet);
            answer = Math.min(answer, Math.abs(net1 - net2));
        }
        return answer;
    }
    
    public int counter(int first, int[][] wires) {
        Queue<Integer> q = new LinkedList<>();
        q.add(first);
        boolean[] visited = new boolean[N + 1];
        visited[first] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] wire: wires) {
                if (wire[0] != cur && wire[1] != cur)
                    continue;
                int other = cur == wire[0] ? wire[1] : wire[0];
                if (visited[other])
                    continue;
                visited[other] = true;
                q.add(other);
                cnt++;
            }
        }
        return cnt;
    }
}
