import java.util.*;

class Solution {
    public int solution(int[] arr, int limit) {
        int answer = 0;
        int n = arr.length;
        Integer[] people = new Integer[n];
        
        for (int i = 0; i < n; i++)
            people[i] = arr[i];
        
        Arrays.sort(people, Collections.reverseOrder());
        
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (limit - people[left] >= people[right])
                right--;
            left++;
            answer++;
        }
        
        return answer;
    }
}
