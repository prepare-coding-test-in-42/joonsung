package week11;

import java.util.*;

public class Main {
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] numbers;
    static String[] operators;
    static final String operator[] = {"+", "-", "*", "/"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        
        numbers = new int[n];
        for (int i = 0; i < n; i++)
            numbers[i] = sc.nextInt();
        
        operators = new String[n - 1];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            int cnt = sc.nextInt();
            for (int j = 0; j < cnt; j++) {
                operators[index++] = operator[i];
            }
        }

        perm(new boolean[n - 1], 1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }   
    
    public static void perm(boolean[] v, int depth, int result) {
        if (depth == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (v[i])
                continue;
            
            v[i] = true;
            String op = operators[i];
            int newResult = cal(op, result, numbers[depth]);
            perm(v, depth + 1, newResult);
            v[i] = false;
        }   
    }

    private static int cal(String op, int a, int b) {
        if (op.equals("+")) {
            return a + b;
        } if (op.equals("-")) {
            return a - b;
        } if (op.equals("*")) {
            return a * b; 
        } if (op.equals("/")) {
            return a / b;
        }
        return -1;
    }
}
