package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1182 {
    // BOJ 1182 부분수열의 합
    private static int N;
    private static int S;
    private static int answer = 0;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");

        N = Integer.parseInt(strArr[0]);
        S = Integer.parseInt(strArr[1]);
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        solution();
        System.out.println(answer);
    }

    /**
     * bitmask : 2진 자릿수의 값을 통해 모든 경우의 수를 확인한다.
     */
    private static void solution() {
        for (int bit = 1; bit < Math.pow(2, N); bit++) {
            int sum = 0;
            for (int i = 0; i < N; i++) if ((bit & (1 << i)) != 0) sum += arr[i];
            if (sum == S) answer++;
        }
    }
}
