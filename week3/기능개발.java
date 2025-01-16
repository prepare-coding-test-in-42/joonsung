import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[100];
        Queue<Progress> proQ = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++)
            proQ.add(new Progress(progresses[i], speeds[i]));
        
        int days = 0;
        while (!proQ.isEmpty()) {
            Progress pro = proQ.poll();
            while (!pro.isEnd(days))
                days++;
            answer[days]++;
        }
        return Arrays.stream(answer).filter(i -> i != 0).toArray();
    }
    
    class Progress {
        int value;
        int speed;
        
        public Progress(int value, int speed) {
            this.value = value;
            this.speed = speed;
        }
        
        public boolean isEnd(int days) {
            if (value + speed * days >= 100)
                return true;
            return false;
        }
    }
}
