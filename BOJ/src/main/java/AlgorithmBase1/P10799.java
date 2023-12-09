package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P10799 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            System.out.println(solution(str));
            }
    }

    private static int solution(String str) {
        int answer = 0;
        char pre = ' ';
        Stack<Character> stack = new Stack<>();

        for(Character c : str.toCharArray()) {
            if(c == '(') stack.push(c);
            else if(!stack.isEmpty()){
                stack.pop();
                if(pre == '(') answer += stack.size();
                else answer++;
            }
            pre = c;
        }
        return answer;
    }
}
