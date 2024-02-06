package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10819 {
    // BOJ 10819 차이를 최대로
    private static int N;
    private static int answer = Integer.MIN_VALUE;
    private static int[] inputArr;
    private static boolean[] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        used = new boolean[N];

        bruteforce(N, new int[N]);

        System.out.println(answer);
    }

    private static void bruteforce(int len, int[] arr) {
        if(len == 0) {
            getSum(arr);
            return;
        }

        for(int i = 0; i<N; i++) {
            if(!used[i]) {
                used[i] = true;
                arr[N - len] = inputArr[i];
                bruteforce(len - 1, arr);
                used[i] = false;
            }
        }
    }

    private static void getSum(int[] arr) {
        int sum = 0;

        for(int i=0; i<N-1; i++) {
            sum += Math.abs(arr[i] - arr[i+1]);
        }

        answer = Math.max(answer, sum);
    }
}
