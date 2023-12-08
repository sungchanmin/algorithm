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

            System.out.println("#" + test_case + " " + calc(n, k));
        }
    }

    private static long calc(int n, int k) {
        long numerator = 1;
        long denominator = 1;

        for (int i = n; i > n - k; i--) {
            numerator = (numerator * i) % num;
        }

        for (int i = k; i > 1; i--) {
            denominator = (denominator * i) % num;
        }

        // 분모의 역원을 구해서 나누기를 수행
        long result = (numerator * power(denominator, num - 2)) % num;
        return result;
    }

    private static long power(long base, long exponent) {
        if (exponent == 0) {
            return 1;
        }

        long halfPower = power(base, exponent / 2) % num;
        long result = (halfPower * halfPower) % num;

        if (exponent % 2 == 1) {
            result = (result * base) % num;
        }

        return result;
    }
}