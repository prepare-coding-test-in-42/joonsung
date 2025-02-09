import java.util.*;

class Solution {
    int n;
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        List<List<Integer>> permutations = getPermutations();
        int answer = 0;
        
        for (List<Integer> perm: permutations) {
            int piro = k;
            int cnt = 0;
            
            for (int i: perm) {
                int required = dungeons[i][0];
                int consume = dungeons[i][1];
                
                if (piro < required)
                    continue;
                
                piro -= consume;
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
    
    public List<List<Integer>> getPermutations() {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new boolean[n], new ArrayList<>(), result);

        return result;
    }
    
    public void backtrack(boolean[] visited, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            
            visited[i] = true;
            current.add(i);
            backtrack(visited, current, result);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}
