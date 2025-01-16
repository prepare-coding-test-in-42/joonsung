import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++)
            bridge.add(0);
        
        int sec = 0;
        int avail = weight;
        int idx = 0;
        while (idx < truck_weights.length) {
            sec++;
            avail += bridge.poll();
            int truck = truck_weights[idx];
            if (truck <= avail) {
                bridge.add(truck);
                avail -= truck;
                idx++;
                continue;
            }
            bridge.add(0);            
        }
        return sec + bridge_length;
    }
}
