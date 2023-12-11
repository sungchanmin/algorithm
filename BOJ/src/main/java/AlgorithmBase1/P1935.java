package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1935 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String str = br.readLine();

            for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());

            System.out.println(solution(str, arr));
        }
    }

    private static String solution(String str, int[] arr) {
        Stack<Double> stack = new Stack<>();

        for(char c : str.toCharArray()) {
            if(Character.isAlphabetic(c)) stack.push((double) arr[c - 65]);
            else calc(c, stack);
        }

        return String.format("%.2f", stack.peek());
    }

    private static void calc(char c, Stack<Double> stack) {
        double b = stack.pop();
        double a = stack.pop();

        switch (c) {
            case '+':
                stack.push(a + b);
                break;
            case '-':
                stack.push(a - b);
                break;
            case '*':
                stack.push(a * b);
                break;
            case '/':
                stack.push(a / b);
                break;
        }
    }
}