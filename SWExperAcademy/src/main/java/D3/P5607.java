package D3;

import java.util.Scanner;

public class P5607 {
    // 5607. 조합
    private static final long num = 1234567891;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            System.out.println("#" + test_case + " " + clac(n, k));
        }
    }

    private static long clac(int n, int k) {
        long p = 1;
        long c = 1;

        for(int i=n; i>n-k; i--) {
            p *= i;
            p %= num;
        }

        for(int i=k; i>1; i--) {
            c *= i;
            c %= num;
        }

        return p/c;
    }

}
