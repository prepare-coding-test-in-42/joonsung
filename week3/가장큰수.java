import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int n = numbers.length;
        String[] strings = new String[n];
        
        for (int i = 0; i < n; i++)
            strings[i] = Integer.toString(numbers[i]);
        
        Arrays.sort(strings, (s1, s2) -> {
            return (s2 + s1).compareTo(s1 + s2);
        });

        StringBuilder sb = new StringBuilder();
        for (String s: strings)
            sb.append(s);
        
        String answer = sb.toString();
        if (answer.charAt(0) == '0')
            return "0";
        return answer;
    }
}
