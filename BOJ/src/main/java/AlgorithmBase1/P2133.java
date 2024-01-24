package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        // 벽 너비 길이가 홀수인 경우 채울 수 없다.
        if (N % 2 != 0) System.out.println("0");
        else {
            dp[0] = 1;
            dp[2] = 3;

            for (int i = 4; i <= N; i += 2) {
                // 3*2 벽을 채우는 방법은 3가지 이다.
                // 따라서 이전에 채운(짝수) 방법의 가짓수에 3을 곱해준다.
                dp[i] = dp[i - 2] * 3;

                // 벽의 너비가 6이상인 경우 채울 수 있는 예외 2가지가 있다.
                // 따라서 아래와 같이 이전 방법의 가짓수에 2를 곱하여 더해준다.
                for (int j = i - 4; j >= 0; j -= 2) {
                    dp[i] += dp[j] * 2;
                }
            }

            System.out.println(dp[N]);
        }
    }
}