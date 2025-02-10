import java.util.*;

class Solution {
    int n;
    List<List<String>> answer = new LinkedList<>();
    
    public List<String> solution(String[][] tickets) {
        n = tickets.length;
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        List<String> path = new LinkedList<>();
        path.add("ICN");
        dfs(path, new boolean[n], tickets);
        return answer.get(0);
    }
    
    public void dfs(List<String> path, boolean[] visited, String[][] tickets) {
        if (path.size() > n) {
            answer.add(path);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            if (!tickets[i][0].equals(path.get(path.size() - 1)))
                continue;
            
            visited[i] = true;
            List<String> newPath = new LinkedList<>(path);
            newPath.add(tickets[i][1]);
            dfs(newPath, visited, tickets);
            visited[i] = false;
        }
    }
}
