import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int pa = 0;
        int pb = 0;
        
        while (pa < A.length && pb < B.length) {
            if (B[pb] > A[pa]) {
                answer++;
                pa++;
            }
            pb++;
        }
        
        return answer;
    }
}
