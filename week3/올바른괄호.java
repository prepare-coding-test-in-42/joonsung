import java.util.*;

class Solution {
    boolean solution(String s) {
        char OPEN = '(';
        char CLOSE = ')';
        
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == OPEN)
                stack.push(c);
            else if (c == CLOSE) {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}
