package AlgorithmBase1;

import java.util.Scanner;

public class P1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(cntZero(n));
    }

    private static int cntZero(int n) {
        int cnt = 0;

        while(n >= 5) {
            cnt += n / 5;
            n /= 5;
        }

        return cnt;
    }
}