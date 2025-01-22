import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        for (int idx = 0; idx < n; idx++) {
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];
            
            int[] sliced = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(sliced);
            answer[idx] = sliced[k - 1];
        }
        return answer;
    }
}
