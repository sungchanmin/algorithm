package chapter05.StackQueue.no40;

import java.util.Scanner;
import java.util.Stack;

public class IronStick {
    private static int solution(String[] strArr) {
        int answer = 0, cnt = 0, k=0;
        Stack<String> stack = new Stack<>();
        String beofre = "";

        while(true){
            cnt = 0;

            for(String s : strArr) {
                if (s.equals("(")) stack.push(s);
                else if(s.equals(")")) {
                    if(stack.size() > 1 && beofre.equals("(")) cnt++;
                    if(!stack.empty()) stack.pop();
                    if(stack.empty() && cnt != 0) {
                        answer += cnt + 1;
                        cnt = 0;
                    }
                }
                beofre = s;
            }

            stack.clear();
            cnt = 0;
            int a = 0, b = 0;

            for(String s : strArr) {
                if(s.equals("(")) stack.push(s);
                else if(s.equals(")") && !stack.empty()) {
                    stack.pop();
                    cnt++;
                    if(stack.empty()) {
                        if(cnt <= 2) for (int i=a; i<b+1; i++) strArr[i] = "_";
                        a = b+1;
                        cnt = 0;
                    }
                }
                b++;
            }

            stack.clear();

            for(int i=0; i<strArr.length; i++) {
                if(strArr[i].equals("(")) {
                    if (stack.empty()) {
                        stack.push(strArr[i]);
                        strArr[i] = "_";
                    } else stack.push(strArr[i]);
                }

                if(strArr[i].equals(")")) {
                    stack.pop();
                    if(stack.empty()) strArr[i] = "_";
                }
            }

            boolean isEnd = true;

            for(String s : strArr) if(!s.equals("_")) isEnd = false;

            if(isEnd) return answer;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split("");
        System.out.println(solution(strArr));
    }
}
