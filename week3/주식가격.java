import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Stack<Stock> stack = new Stack<>();
        for (int sec = 0; sec < n; sec++) {
            while (!stack.isEmpty() && stack.peek().price > prices[sec]) {
                Stock stock = stack.pop();
                answer[stock.sec] = sec - stock.sec;
            }
            stack.push(new Stock(sec, prices[sec]));
        }
        while (!stack.isEmpty()) {
            Stock stock = stack.pop();
            answer[stock.sec] = (n - 1) - stock.sec;
        }
        
        return answer;
    }
    
    class Stock {
        int sec;
        int price;
        
        public Stock(int sec, int price) {
            this.sec = sec;
            this.price = price;
        }
    }
}
