package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];
        String[] strArr = br.readLine().split(" ");

        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(strArr[i]);
            int max = 0;

            for(int j=0; j<i; j++) {
                if(Integer.parseInt(strArr[j]) < n) max = Math.max(max, dp[j]);
            }

            dp[i] = max + n;
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}
