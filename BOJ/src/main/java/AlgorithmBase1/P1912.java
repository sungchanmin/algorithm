package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = toIntArr(br.readLine());
        int[] dp = new int[arr.length];

        dp[0] = arr[0];

        for(int i=1; i<n; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

    private static int[] toIntArr(String str) {
        String[] strArr = str.split(" ");
        int[] arr = new int[strArr.length];

        for(int i=0; i<arr.length; i++) arr[i] = Integer.parseInt(strArr[i]);

        return arr;
    }
}
