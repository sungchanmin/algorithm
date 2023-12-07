package AlgorithmBase1;

import java.io.*;
import java.util.Stack;

public class P1406B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Stack<Character> rightStack = new Stack<>();
        Stack<Character> leftStack = new Stack<>();

        for(char c : str.toCharArray()) rightStack.push(c);

        for(int i=0; i<n; i++) {
            String cmd = br.readLine();

            switch (cmd.charAt(0)) {
                case 'L' :
                    if(!rightStack.empty()) leftStack.push(rightStack.pop());
                    break;
                case 'D' :
                    if(!leftStack.empty()) rightStack.push(leftStack.pop());
                    break;
                case 'B' :
                    if(!rightStack.empty()) rightStack.pop();
                    break;
                case 'P' :
                    rightStack.push(cmd.charAt(2));
                    break;
            }
        }

        while(!rightStack.empty()) leftStack.push(rightStack.pop());
        while (!leftStack.empty()) bw.write(leftStack.pop());

        bw.flush();
        br.close();
        bw.close();
    }
}