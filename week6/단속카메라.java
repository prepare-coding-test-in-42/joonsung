import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int pos = routes[0][1];
        int cam = 1;
        
        for (int[] route : routes) {
            int in = route[0];
            int out = route[1];
            
            if (in > pos) {
                pos = out;
                cam++;
            }
        }
        
        return cam;
    }
}
