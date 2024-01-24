package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[][] dp = new int[2][N];

        String[] strArr = br.readLine().split(" ");

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(strArr[i]);

        dp[0][0] = arr[0];
        dp[1][0] = arr[0];

        int max = arr[0];

        for (int i = 1; i < N; i++) {
            // 수를 제거하지 않는 경우의 최대 값
            dp[0][i] = Math.max(dp[0][i-1] + arr[i], arr[i]);
            // 자신을 제거하거나 포함하는 경우의 최대 값
            dp[1][i] = Math.max(dp[1][i-1] + arr[i], dp[0][i-1]);
            max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
        }

        System.out.println(max);
    }
}