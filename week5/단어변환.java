import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        boolean[] visited = new boolean[n];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.str.equals(target))
                return cur.steps;
            
            for (int i = 0; i < n; i++) {
                if (visited[i])
                    continue;
                if (!isNear(cur.str, words[i]))
                    continue;
                
                visited[i] = true;
                q.add(new Node(words[i], cur.steps + 1));
            }
        }
        
        return 0;
    }
    
    public boolean isNear(String src, String dst) {
        int cnt = 0;
        for (int i = 0; i < src.length(); i++) {
            if (src.charAt(i) == dst.charAt(i))
                cnt++;
        }

        return src.length() - 1 == cnt;
    }
    
    class Node {
        String str;
        int steps;
        
        public Node(String str, int steps) {
            this.str = str;
            this.steps = steps;
        }
    }
}
