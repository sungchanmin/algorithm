package AlgorithmBase1;

import java.io.*;
import java.util.Stack;

public class P1918 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String str = br.readLine();
            solution(str, bw);
            bw.flush();
        }
    }

    private static void solution(String str, BufferedWriter bw) throws IOException {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                bw.write(c);
            } else {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    closeParenthesis(stack, bw);
                } else {
                    precedenceCheck(c, stack, bw);
                }
            }
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
    }

    private static void closeParenthesis(Stack<Character> stack, BufferedWriter bw) throws IOException {
        while (!stack.isEmpty() && stack.peek() != '(') {
            bw.write(stack.pop());
        }
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    private static void precedenceCheck(char c, Stack<Character> stack, BufferedWriter bw) throws IOException {
        while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c) && stack.peek() != '(') {
            bw.write(stack.pop());
        }
        stack.push(c);
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}
