package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1309 {
    private static final int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3];

        dp[0][0] = 1;   // 양쪽 우리 모두에 사자가 없는 경우
        dp[0][1] = 1;   // 왼쪽 우리에만 사자가 있는 경우
        dp[0][2] = 1;   // 오른쪽 우리에만 사자가 있는 경우

        for (int i = 1; i < n; i++) {
            dp[i][0] = ((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        System.out.println(((dp[n - 1][0] + dp[n - 1][1]) % MOD + dp[n - 1][2]) % MOD);
    }
}
