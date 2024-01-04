package AlgorithmBase1;

import java.util.Scanner;

public class P2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n][2];

        dp[0][0] = 0;
        dp[0][1] = 1;

        for(int i=1; i<n; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[n-1][0] + dp[n-1][1]);

    }
}
