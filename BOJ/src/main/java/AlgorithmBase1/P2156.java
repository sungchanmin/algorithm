package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            if(i == 0) dp[0] = arr[0];
            else if(i == 1) dp[1] = arr[0] + arr[1];
            else if(i == 2) dp[2] = Math.max(arr[0] + arr[2], Math.max(arr[1] + arr[2], dp[1]));
            else dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
