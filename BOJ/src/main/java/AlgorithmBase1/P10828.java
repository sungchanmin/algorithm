package AlgorithmBase1;

import java.util.Scanner;

public class P10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(sc.nextLine());
        Stack stack = new Stack(n);

        for (int i = 0; i < n; i++) {
            String[] strArr = sc.nextLine().split(" ");

            switch (strArr[0]) {
                case "push":
                    stack.push(Integer.parseInt(strArr[1]));
                    break;
                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty()).append("\n");
                    break;
                case "top":
                    sb.append(stack.top()).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }

    private static class Stack {
        int[] stack;
        int size;

        public Stack(int n) {
            stack = new int[n];
            size = 0;
        }

        public void push(int i) {
            stack[size] = i;
            size++;
        }

        public Object pop() {
            if (size == 0) return -1;
            size--;
            return stack[size];
        }

        public int size() {
            return size;
        }

        public int empty() {
            return size == 0 ? 1 : 0;
        }

        public Object top() {
            return size == 0 ? -1 : stack[size - 1];
        }
    }
}
