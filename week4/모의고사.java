import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] omrs = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < omrs.length; j++) {
                if (omrs[j][i % omrs[j].length] == answers[i])
                    scores[j]++;
            }
        }
        
        int highScore = Arrays.stream(scores).max().orElse(0);
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == highScore)
                answer.add(i + 1);
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
