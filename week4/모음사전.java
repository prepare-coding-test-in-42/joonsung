import java.util.*;

class Solution {
    public int solution(String word) {
        List<String> result = getPermutations();
        Collections.sort(result);
        int cnt = 1;
        for (int i = 0; i < result.size(); i++) {
            if (word.equals(result.get(i)))
                return cnt;
            cnt++;
        }
        return -1;
    }
    
    public List<String> getPermutations() {
        List<String> result = new ArrayList<>();
        permutate("", "AEIOU", result);
        return result;
    }
    
    public void permutate(String s, String word, List<String> result) {
        if (s.length() > 0)
            result.add(s);
        if (s.length() == 5)
            return;
        
        for (int i = 0; i < word.length(); i++) {
            permutate(s + word.substring(i, i + 1), word, result);
        }
    }
}
