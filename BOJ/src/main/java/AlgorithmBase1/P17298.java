package AlgorithmBase1;

import java.util.Scanner;
import java.util.Stack;

public class P17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        System.out.println(solution(arr));
    }

    private static StringBuilder solution(int[] arr) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<arr.length; i++) {
            while(!stack.empty()) {
                if (arr[stack.peek()] < arr[i]) {
                    arr[stack.pop()] = arr[i];
                } else break;
            }
            stack.push(i);
        }

        while(!stack.empty()) {
            arr[stack.pop()] = -1;
        }

        for(int i : arr) sb.append(i).append(" ");

        return sb;
    }
}