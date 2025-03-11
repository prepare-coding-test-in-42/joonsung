import java.util.*;

public class Main {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        K = sc.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        Dice dice = new Dice();
        for (int i = 0; i < K; i++) {
            int dir = sc.nextInt();
            roll(dice, dir);
        }
    }

    private static void roll(Dice dice, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;

        dice.roll(dir);

        if (map[nx][ny] == 0) {
            map[nx][ny] = dice.bottom;
        } else {
            dice.bottom = map[nx][ny];
            map[nx][ny] = 0;
        }

        x = nx;
        y = ny;
        System.out.println(dice.top);
    }
}

class Dice {
    static final int EAST = 1, WEST = 2, NORTH = 3, SOUTH = 4;

    int top, bottom, front, back, left, right;

    Dice() {
        this.top = 0;
        this.bottom = 0;
        this.front = 0;
        this.back = 0;
        this.left = 0;
        this.right = 0;
    }

    public void roll(int dir) {
        int temp;
        switch (dir) {
            case EAST:
                temp = top;
                top = left;
                left = bottom;
                bottom = right;
                right = temp;
                break;
            case WEST:
                temp = top;
                top = right;
                right = bottom;
                bottom = left;
                left = temp;
                break;
            case NORTH:
                temp = top;
                top = front;
                front = bottom;
                bottom = back;
                back = temp;
                break;
            case SOUTH:
                temp = top;
                top = back;
                back = bottom;
                bottom = front;
                front = temp;
                break;
        }
    }
}
