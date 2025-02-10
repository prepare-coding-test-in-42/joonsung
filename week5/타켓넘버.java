class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int result, int idx) {
        if (idx == numbers.length) {
            if (result == target)
                answer++;
            return;
        }
        
        dfs(numbers, target, result + numbers[idx], idx + 1);
        dfs(numbers, target, result - numbers[idx], idx + 1);
    }
}
