import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        /*
        최소 거리 x를 두고 이 최소 거리를 맞추기 위해 제거해야 하는 돌의 개수를 기준으로 범위를 이분.
        */
        
        int left = 1;
        int right = distance;
        int answer = left;
        Arrays.sort(rocks);
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int prv = 0;
            int cnt = 0;
            for (int rock: rocks) {
                if (rock - prv < mid) {
                    cnt++;
                    if (cnt > n)
                        break;
                    continue;
                }
                prv = rock;
            }
            
            if (distance - prv < mid)
                cnt++;
            
            // 가능한 최소거리의 최댓값을 찾는 문제이기 때문에 
            // 값을 갱신하는 조건은 최소거리가 더 작은 경우 
            // 최소거리가 최적값보다 더 작다 -> 최소거리를 늘려야 함 
            // 최소거리가 느는 경우는 left를 날릴 때
            // -> cnt >= n 말고 cnt <= n으로 해야 맞음
            if (cnt <= n) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
}
