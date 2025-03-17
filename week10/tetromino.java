import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int[][][] tetrominos = {
                { {0, 0, 0, 0}, {0, 1, 2, 3} }, // ㅡ 모양
                { {0, 0, 1, 1}, {0, 1, 0, 1} }, // ㅁ 모양
                { {0, 1, 2, 2}, {0, 0, 0, 1} }, // L 모양
                { {2, 0, 1, 2}, {0, 1, 1, 1} }, // L 대칭
                { {0, 1, 1, 2}, {0, 0, 1, 1} }, // Z 모양
                { {2, 1, 1, 0}, {0, 0, 1, 1} }, // Z 대칭
                { {0, 0, 0, 1}, {0, 1, 2, 1} }  // T 모양
        };

        long max = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < tetrominos.length; j++) {
                max = Math.max(max, calculate(tetrominos[j][0], tetrominos[j][1]));
            }
            rotate();
        }

        System.out.println(max);
    }

    public static long calculate(int[] di, int[] dj) {
        int len = di.length;
        long max = 0;
        int n = map.length;
        int m = map[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long sum = 0;

                for (int l = 0; l < len; l++) {
                    int ni = i + di[l];
                    int nj = j + dj[l];

                    if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
                        sum = 0;
                        break;
                    }

                    sum += map[ni][nj];
                }

                max = Math.max(max, sum);
            }
        }

        return max;
    }

    public static void rotate() {
        int n = map.length;
        int m = map[0].length;
        int[][] temp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = map[n - 1 - j][i];
            }
        }

        map = temp;
    }
}
