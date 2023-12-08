package D3;

import java.util.Scanner;
import java.util.Stack;

public class P1234 {
    // 1234. 비밀번호
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            String[] strArr = sc.nextLine().split(" ");
            System.out.print("#" + test_case + " ");
            solutin(strArr[1].split(""));
            System.out.println();
        }
    }

    private static void solutin(String[] strArr) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<strArr.length; i++) {
            int n = Integer.parseInt(strArr[i]);

            if(stack.isEmpty()) stack.push(n);
            else {
                if (stack.peek() == n) stack.pop();
                else stack.push(n);
            }
        }

        int[] arr = new int[stack.size()];
        int len = stack.size();

        for(int i=0; i<len; i++) {
            arr[arr.length - 1 - i] = stack.pop();
        }

        for(int i : arr) System.out.print(i);
    }
}