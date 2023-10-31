package chapter05.StackQueue.no37;

import java.util.Scanner;
import java.util.Stack;

public class RemoveParenthesis {
    private static String solution(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for(String s : strArr) {
            if(s.equals("(")) stack.push(s);
            else if(s.equals(")")) stack.pop();
            else if(stack.size() == 0) sb.append(s);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split("");
        System.out.println(solution(strArr));
    }
}
