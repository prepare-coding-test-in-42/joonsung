import java.util.*;

public class Main {
    static final int EMPTY = 0, WALL = 6;

    static int n, m, answer = Integer.MAX_VALUE;
    static List<CCTV> cctvs;
    static int[][] office;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();

        office = new int[n][m];
        cctvs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int value = sc.nextInt();
                office[i][j] = value;
                if (value != EMPTY && value != WALL) {
                    cctvs.add(new CCTV(i, j, value));
                }
            }
        }

        backtrack(0);

        System.out.println(answer);
    }

    static void backtrack(int depth) {
        if (depth == cctvs.size()) {
            for (CCTV cctv: cctvs)
                cctv.watch();

            answer = Math.min(answer, countBlindSpotAndClear());
            return;
        }

        CCTV cctv = cctvs.get(depth);
        for (int dir = 0; dir < 4; dir++) {
            cctv.dir = dir;
            backtrack(depth + 1);
        }
    }

    static int countBlindSpotAndClear() {
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (office[i][j] == EMPTY)
                    cnt++;
                else if (office[i][j] == '#')
                    office[i][j] = EMPTY;
            }
        }

        return cnt;
    }

    static class CCTV {
        static final int[] di = {-1, 0, 1, 0};
        static final int[] dj = {0, 1, 0, -1};
    
        int i, j, dir, type;
    
        public CCTV(int i, int j, int type) {
            this.i = i;
            this.j = j;
            this.type = type;
        }
    
        public void watch() {
            semiWatch(dir);
            
            if (type == 2) {
                semiWatch((dir + 2) % 4);
            }
            else if (type == 3) {
                semiWatch((dir + 1) % 4);
            }
            else if (type == 4) {
                semiWatch((dir + 1) % 4);
                semiWatch((dir + 3) % 4);
            }
            else if (type == 5) {
                semiWatch((dir + 1) % 4);
                semiWatch((dir + 2) % 4);
                semiWatch((dir + 3) % 4);
            }
        }
    
        private void semiWatch(int dir) {
            int ni = i;
            int nj = j;

            while (true) {
                ni += di[dir];
                nj += dj[dir];
    
                if (ni < 0 || nj < 0 || ni >= n || nj >= m)
                    return;
                if (office[ni][nj] == WALL)
                    return;
                    
                if (office[ni][nj] == EMPTY)
                    office[ni][nj] = '#';
            }
        }
    }
}
