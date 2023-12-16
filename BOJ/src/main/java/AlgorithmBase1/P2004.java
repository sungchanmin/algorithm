package AlgorithmBase1;

import java.util.Scanner;

public class P2004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(solution(n, m));
    }

    private static int cntPow(int p, int n) {
        int cnt = 0;

        while(n >= p) {
            cnt += n / p;
            n /= p;
        }

        return cnt;
    }

    private static int solution(int n, int m) {
        int a = cntPow(2, n) - cntPow(2, m) - cntPow(2, n - m);
        int b = cntPow(5, n) - cntPow(5, m) - cntPow(5, n - m);

        return Math.min(a, b);
    }
}