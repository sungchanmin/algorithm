package AlgorithmBase1;

import java.util.Scanner;
import java.util.Stack;

public class P1874 {
    private static Scanner sc = new Scanner(System.in);
    private static StringBuilder sb = new StringBuilder();
    private static Stack<Integer> stack = new Stack<>();
    private static int num = 0;

    public static void main(String[] args) {

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (!getNumber(sc.nextInt())) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }

    private static boolean getNumber(int n) {
        if (num < n) {
            while (num < n) {
                stack.push(++num);
                sb.append("+\n");
            }
        } else {
            while (!stack.empty()) {
                if (stack.peek() == n) break;
                else {
                    stack.pop();
                    sb.append("-\n");
                }
            }
            if(stack.empty()) return false;
        }

        stack.pop();
        sb.append("-\n");
        return true;
    }
}
