package AlgorithmBase1;//import java.io.*;
//import java.util.Stack;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        solution(str);
//        br.close();
//    }
//
//    private static void solution(String str) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        Stack<Character> stack = new Stack();
//        boolean isTag = false;
//
//        for(char c : str.toCharArray()) {
//            if(c == '<') isTag = true;
//
//            if(isTag || c == ' ') {
//                while(!stack.empty()) {
//                    bw.write(stack.pop());
//                }
//                bw.write(c);
//            } else {
//                stack.push(c);
//            }
//
//            if(c == '>') isTag = false;
//        }
//
//        while(!stack.empty()) {
//            bw.write(stack.pop());
//        }
//
//        bw.flush();
//        bw.close();
//    }
//}

import java.io.*;
import java.util.Stack;

public class P17413 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String str = br.readLine();
            solution(str, bw);
        }
    }

    private static void solution(String str, BufferedWriter bw) throws IOException {
        Stack<Character> stack = new Stack<>();
        boolean isTag = false;

        for (char c : str.toCharArray()) {
            if (c == '<') {
                isTag = true;
            }

            if (isTag || c == ' ') {
                flushStack(stack, bw);
                bw.write(c);
            } else {
                stack.push(c);
            }

            if (c == '>') {
                isTag = false;
            }
        }

        flushStack(stack, bw);

        bw.flush();
    }

    private static void flushStack(Stack<Character> stack, BufferedWriter bw) throws IOException {
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
    }
}
