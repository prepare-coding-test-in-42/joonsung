import java.util.*;

public class Main {
    static final int EMPTY = 0, WALL = 1, VIRUS = 2;
    static final int[] di = {0,0,-1,1};
    static final int[] dj = {1,-1,0,0};

    static int n, m;
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] lab = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lab[i][j] = sc.nextInt();
            }
        }

        recursive(0, lab);
        System.out.println(max);
    }

    static void recursive(int count, int[][] lab) {
        if (count == 3) {
            int[][] virtualLab = copy(lab);
            spread(virtualLab);
            max = Math.max(max, count(virtualLab));
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == EMPTY) {
                    lab[i][j] = WALL;
                    recursive(count + 1, lab);
                    lab[i][j] = EMPTY;
                }
            }
        }
    }

    static int[][] copy(int[][] lab) {
        int[][] c = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                c[i][j] = lab[i][j];
        }

        return c;
    }

    static void spread(int[][] lab) {
        Queue<Pos> virusPos = getVirusPos(lab);

        while (!virusPos.isEmpty()) {
            Pos cur = virusPos.poll();
            for (int d = 0; d < 4; d++) {
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];

                if (ni < 0 || ni >= n || nj < 0 || nj >= m)
                    continue;
                if (lab[ni][nj] != EMPTY)
                    continue;

                lab[ni][nj] = VIRUS;
                virusPos.add(new Pos(ni, nj));
            }
        }

    }

    static Queue<Pos> getVirusPos(int[][] lab) {
        Queue<Pos> virusPos = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == VIRUS) {
                    virusPos.add(new Pos(i, j));
                }
            }
        }

        return virusPos;
    }

    static int count(int[][] lab) {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == EMPTY)
                    cnt++;
            }
        }

        return cnt;
    }

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

