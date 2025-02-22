import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int len = number.length();

        for (int i = 0; i < len; i++) {
            char digit = number.charAt(i);

            while (!stack.isEmpty() && stack.peek() < digit && k > 0) {
                stack.pop();
                k--; 
            }

            stack.push(digit);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        
        return result.toString();
    }
}

