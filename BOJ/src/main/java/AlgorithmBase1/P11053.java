package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = toIntArr(br.readLine());
        int[] dp = new int[n];

        dp[0] = 1;

        for(int i=1; i<n; i++) {
            int len = 1;
            for(int j=0; j<i; j++) {
                if(arr[j] < arr[i]) len = Math.max(len, dp[j] + 1);
            }
            dp[i] = len;
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

    private static int[] toIntArr(String str) {
        String[] strArr = str.split(" ");
        int[] arr = new int[strArr.length];

        for(int i=0; i<strArr.length; i++) arr[i] = Integer.parseInt(strArr[i]);

        return arr;
    }
}
