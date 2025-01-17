import java.util.*;

class Solution {
    static final String INSERT = "I";
    static final String DELETE = "D";
    static final String MAX = "1";
    static final String MIN = "-1";
    
    public int[] solution(String[] operations) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (String op : operations) {
            String[] ops = op.split(" ");
            if (ops[0].equals(INSERT)) {
                int num = Integer.parseInt(ops[1]);
                minHeap.add(num);
                maxHeap.add(num);
            } else if (ops[0].equals(DELETE)) {
                if (minHeap.isEmpty())
                    continue;
                
                if (ops[1].equals(MAX)) {
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                } else if (ops[1].equals(MIN)) {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }
        
        if (minHeap.isEmpty())
            return new int[] {0, 0};
        return new int[] {maxHeap.peek(), minHeap.peek()};
    }
}
