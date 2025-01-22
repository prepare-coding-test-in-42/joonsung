import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int scov: scoville)
            minHeap.add(scov);
        
        int cnt = 0;
        while (minHeap.size() > 1 && minHeap.peek() < K) {
            int newScov = minHeap.poll() + 2* minHeap.poll();
            minHeap.add(newScov);
            cnt++;
        }
        if (minHeap.peek() < K)
            return -1;
        return cnt;
    }
}
