import java.util.*;

class Solution {
    static final int WALL = 0;
    static final int EMPTY = 1;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    
    int n, m;
    int answer = -1;
    
    public int solution(int[][] maps) {
        n = maps.length - 1;
        m = maps[0].length - 1;
        
        bfs(maps, new boolean[n + 1][m + 1]);
        return answer;
    }
    
    public void bfs(int[][] maps, boolean[][] visited) {
        Pos start = new Pos(0, 0, 1);
        visited[start.y][start.x] = true;
        Queue<Pos> q = new LinkedList<>();
        q.add(start);
        
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int newX = cur.x + dx[dir];
                int newY = cur.y + dy[dir];
                
                if (newX == m && newY == n) {
                    answer = cur.length + 1;
                    return;
                }
                if (newX < 0 || newY < 0 || newX > m || newY > n)
                    continue;
                if (visited[newY][newX])
                    continue;
                if (maps[newY][newX] == WALL)
                    continue;
                
                visited[newY][newX] = true;
                q.add(new Pos(newX, newY, cur.length + 1));
            }
        }
    }
    
    class Pos {
        int x;
        int y;
        int length;
        
        public Pos(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }
}
