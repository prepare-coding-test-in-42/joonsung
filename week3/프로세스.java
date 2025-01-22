import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> processQ = new LinkedList<>();
        List<Integer> sortedPri = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            processQ.add(new Process(i, priorities[i]));
            sortedPri.add(priorities[i]);
        }
            
        sortedPri.sort(Collections.reverseOrder());
        int maxIdx = 0;
        while (!processQ.isEmpty()) {
            Process pro = processQ.poll();
            if (pro.priority != sortedPri.get(maxIdx)) {
                processQ.add(pro);
                continue;
            }
            if (pro.idx == location)
                return maxIdx + 1;
            maxIdx++;
        }
        return -1;
    }
    
    class Process {
        int idx;
        int priority;
        
        public Process(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}
