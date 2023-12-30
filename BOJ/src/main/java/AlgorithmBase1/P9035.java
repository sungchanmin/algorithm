package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9035 {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        solution(10);

        for (int i = 0; i < n; i++) sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");

        System.out.println(sb);
    }

    private static void solution(int n) {
        dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }
}
