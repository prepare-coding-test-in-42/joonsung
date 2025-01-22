import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth: clothes) {
            String key = cloth[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        int answer = 1;
        for (var entry: map.entrySet()) {
            answer *= entry.getValue() + 1;
        }
        return answer - 1;
    }
}
