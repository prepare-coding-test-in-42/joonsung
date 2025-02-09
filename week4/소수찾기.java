import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> permutations = getPermutations(numbers);
        int answer = 0;
        for (int num: permutations) {
            System.out.println(num);
            if (isPrime(num))
                answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(int num) {
        if (num < 2)
            return false;
        if (num < 4)
            return true;
        
        int i = 2;
        while (true) {
            if (i > num / i)
                break;
            if (num % i == 0)
                return false;
            i++;
        }
        return true;
    }
    
    public Set<Integer> getPermutations(String src) {
        Set<Integer> permutations = new HashSet<>();
        permutate("", src, permutations);
        return permutations;
    }
    
    public void permutate(String result, String src, Set<Integer> permutations) {
        if (result.length() != 0)
            permutations.add(Integer.parseInt(result));
        
        for (int i = 0; i < src.length(); i++) {
            String newResult = result + src.substring(i, i + 1);
            String newSrc = src.substring(0, i) + src.substring(i + 1, src.length());
            permutate(newResult, newSrc, permutations);
        }
    }
}
