package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr;
        int[] dp = new int[N];

        dp[0] = Integer.parseInt(br.readLine());

        for(int i=1; i<N; i++) {
            // 윗층의 최대 값들을 복사하여 보관한다.
            arr = Arrays.copyOf(dp, N);
            String[] strArr = br.readLine().split(" ");

            for(int j=0; j<=i; j++) {
                int n = Integer.parseInt(strArr[j]);
                // 현재 층에서 가장 왼쪽에 있는 수의 경우
                if(j==0) dp[j] = arr[0] + n;
                // 현재 층에서 가장 오른쪽에 있는 수의 경우
                else if(j==i) dp[j] = arr[j-1] + n;
                // 그 외의 경우 윗층의 값중 최대 값을 선택한다.
                else dp[j] = Math.max(arr[j-1], arr[j]) + n;
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
