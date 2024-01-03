package AlgorithmBase1;

import java.io.IOException;
import java.util.Scanner;

public class P10844 {
    private static final long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] arr = new long[n + 1][10];

        for (int i = 1; i < 10; i++) arr[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) arr[i][j] = arr[i - 1][1] % MOD;
                else if (j == 9) arr[i][j] = arr[i - 1][8] % MOD;
                else arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % MOD;
            }
        }

        long answer = 0;
        for (long i : arr[n]) answer += i;
        System.out.println(answer % MOD);
    }
}
