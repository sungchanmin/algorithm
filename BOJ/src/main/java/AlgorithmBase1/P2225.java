package AlgorithmBase1;

import java.util.Scanner;

public class P2225 {
   private static final int MOD = 1000000000;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int k = s.nextInt();
        int[][] dp = new int[201][201];

        for(int i=1;i<=k;i++) {
            dp[i][0]=1;
        }

        for(int i=1;i<=k;i++) {
            for(int j=1;j<=n;j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j])%MOD;
            }
        }

        System.out.println(dp[k][n]);
    }
}