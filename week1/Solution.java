import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        
        for (int i = 0; i < n; i++) {
            int width = n - i;
            int height = citations[i];
            if (width <= height)
                return width;
        }
        
        return 0;
    }
}
