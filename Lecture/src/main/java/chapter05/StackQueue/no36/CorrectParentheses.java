package chapter05.StackQueue.no36;

import java.util.Scanner;
import java.util.Stack;

public class CorrectParentheses {
    private static String solution(String[] strArr) {
        Stack<String> stack = new Stack<>();

        for(String s : strArr) {
            if(s.equals("(")) stack.push(s);
            else if(!stack.empty()) stack.pop();
            else return "NO";
        }

        if(!stack.empty()) return "NO";

        return "YES";
    }
    private static String solution2(String[] strArr) {
        int n = 0;

        if(!strArr[0].equals("(") || !strArr[strArr.length - 1].equals(")"))
            return "NO";

        for(String s : strArr) {
            if(s.equals("(")) n++;
            else n--;
        }

        return n == 0 ? "YES" : "NO";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split("");
        System.out.println(solution(strArr));
    }
}
