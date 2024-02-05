package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10974 {
    // BOJ 10974 모든 순열
    private static int N;
    private static int[] arr;
    private static boolean[] used;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        used = new boolean[N];
        solution(N);
    }

    private static void solution(int len) {
        if (len == 0) {
            sb = new StringBuilder();
            for (int i : arr) sb.append(i).append(" ");
            System.out.println(sb.toString().trim());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                arr[N - len] = i + 1;
                solution(len - 1);
                used[i] = false;
            }
        }
    }
}
