package chapter05.StackQueue.no39;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    private static int solution(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i=str.length(); i>0; i--) {
            char c = str.charAt(i - 1);
            if(c - '0' >= 0 && c - '0' <= 9) {
                char top = stack.peek();

                while(top != '+' && top != '-' && top != '*' && top != '/' && !stack.empty()) {
                    stack.pop();

                    if(stack.peek() == '+') c = (char)((c - '0') + (top - '0') + '0');
                    else if(stack.peek() == '-') c = (char)((c - '0') - (top - '0') + '0');
                    else if(stack.peek() == '*') c = (char)((c - '0') * (top - '0') + '0');
                    else if(stack.peek() == '/') c = (char)((c - '0') / (top - '0') + '0');

                    stack.pop();
                    if(!stack.empty()) top = stack.peek();
                }
            }
            stack.push(c);
        }

        return stack.peek() - '0';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
