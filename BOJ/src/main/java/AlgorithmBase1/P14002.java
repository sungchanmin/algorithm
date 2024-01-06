package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = toIntArr(br.readLine());
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int len = Arrays.stream(dp).max().getAsInt();
        int max = Integer.MAX_VALUE;
        sb.append(len).append("\n");

        List<Integer> list = new ArrayList<>();

        for(int i=n-1; i>=0; i--) {
            if(dp[i] == len && arr[i] < max) {
                list.add(arr[i]);
                len--;
                max = arr[i];
            }
        }

        Collections.reverse(list);
        for(int i : list) sb.append(i).append(" ");
        System.out.println(sb);

    }

    private static int[] toIntArr(String str) {
        String[] strArr = str.split(" ");
        int[] arr = new int[strArr.length];

        for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(strArr[i]);

        return arr;
    }
}
