import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = times[0];
        long right = (long)n * times[times.length - 1];
        long answer = right;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for (int time: times) {
                cnt += mid / time;
            }
            
            if (cnt >= n) {
                answer = mid;
                right = mid - 1;
            } else if (cnt < n)
                left = mid + 1;
        }
        
        return answer;
    }
}
