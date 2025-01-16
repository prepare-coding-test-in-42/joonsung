import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> count = new HashMap<>();
        for (String name: participant) {
            Integer newValue = count.getOrDefault(name, 0) + 1;
            count.put(name, newValue);
        }
        
        for (String name: completion) {
            count.put(name, count.get(name) - 1);
        }
        
        for (var entry: count.entrySet()) {
            if (entry.getValue() != 0)
                return entry.getKey();
        }
        
        return "none";
    }
}
