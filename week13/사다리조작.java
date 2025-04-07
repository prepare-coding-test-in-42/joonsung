import java.util.*;

public class Main {
    static int n, m, h;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();

        map = new int[h + 1][n * 2 + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            map[a][b * 2] = 1;
        }


        for (int k = 0; k <= 3; k++) {
            if (backtrack(0, k)) {
                System.out.println(k);
                return;
            }
        }

        System.out.println(-1);
        return;
    }

    static boolean backtrack(int depth, int max) {
        if (depth == max) {
            return check();
        }

        for (int i = 1; i <= h; i++) {
            for (int j = 2; j < 2 * n; j += 2) {
                if (map[i][j] == 1)
                    continue;
                if (map[i][j - 2] == 1 || map[i][j + 2] == 1)
                    continue;
                
                map[i][j] = 1;
                if (backtrack(depth + 1, max))
                    return true;
                map[i][j] = 0;
            }
        }

        return false;
    }

    static boolean check() {
        int line = 1;

        while (line < 2 * n) {
            int i = 1;
            int j = line;
            
            while (i <= h) {
                if (map[i][j - 1] == 1)
                    j -= 2;
                else if (map[i][j + 1] == 1)
                    j += 2;
                i++;
            }

            if (j != line)
                return false;

            line += 2;
        }

        return true;
    }
}
