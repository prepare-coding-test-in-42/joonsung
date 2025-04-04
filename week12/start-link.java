import java.util.*;

public class Main {
    static int n;
    static int answer = Integer.MAX_VALUE;
    static int s[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = sc.nextInt();
            }
        }

        comb(new boolean[n], 0, 0);

        System.out.println(answer);

        sc.close();
    }
    
    static void comb(boolean[] selected, int start, int depth) {
        if (depth == n/2) {
            answer = Math.min(answer, getDistance(selected));
            return;
        }

        for (int i = start; i < n; i++) {
            selected[i] = true;
            comb(selected, i + 1, depth + 1);
            if (answer == 0)
                return;
            selected[i] = false;        
        }

    }

    static int getDistance(boolean[] selected) {
        int startScore = 0, linkScore = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (selected[i] && selected[j]) {
                    startScore += s[i][j] + s[j][i];
                } else if (!selected[i] && !selected[j]) {
                    linkScore += s[i][j] + s[j][i];
                }
            }
        }

        return Math.abs(startScore - linkScore);
    }
}

