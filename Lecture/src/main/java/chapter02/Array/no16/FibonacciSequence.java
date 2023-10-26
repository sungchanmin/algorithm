package chapter02.Array.no16;

import java.util.Scanner;

public class FibonacciSequence {
    private static String solution(int n) {
        String answer = "1 1 2";
        int l = 1, r = 2, tmp;

        for(int i=0; i<n-3; i++) {
            answer += " " + (l + r);
            tmp = r;
            r += l;
            l = tmp;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
