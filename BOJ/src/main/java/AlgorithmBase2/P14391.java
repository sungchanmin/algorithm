package AlgorithmBase2;

import java.util.Arrays;
import java.util.Scanner;

public class P14391 {
    // BOJ 14391 종이 조각
    private static int N, M;
    private static int answer = Integer.MIN_VALUE;
    private static int[][] arr;
    private static boolean[][] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        arr = new int[N][M];
        used = new boolean[N][M];

        for (int i = 0; i < N; i++)
            arr[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();

        solution(0, 0);
        System.out.println(answer);
    }

    /**
     * 현재 칸을 가로로 읽는 경우와 세로로 읽는 모든 경우의 수를 탐색한다.
     *
     * @param n 가로 탐색 인덱스
     * @param m 세로 탐색 인덱스
     */
    private static void solution(int n, int m) {
        // 마지막 칸에 도달한 경우
        if (n == N - 1 && m == M - 1) {
            // 마지막 칸을 가로로 읽는 경우
            used[n][m] = true;
            cal();
            // 마지막 칸을 세로로 읽는 경우
            used[n][m] = false;
            cal();
            return;
        }
        // 범위를 벗어나는 경우 배제
        if (n >= N || m >= M) return;

        // 현재 칸을 가로로 읽는 경우, 다음 칸 탐색
        used[n][m] = true;
        if (m < M - 1) solution(n, m + 1);
        else solution(n + 1, 0);

        // 현재 칸을 세로로 읽는 경우, 다음 칸 탐색
        used[n][m] = false;
        if (m < M - 1) solution(n, m + 1);
        else solution(n + 1, 0);
    }

    private static void cal() {
        int sum = 0;

        // 가로 숫자 계산
        for (int i = 0; i < N; i++) {
            int rowSum = 0;
            for (int j = 0; j < M; j++) {
                if (used[i][j]) rowSum = rowSum * 10 + arr[i][j];
                else {
                    sum += rowSum;
                    rowSum = 0;
                }
            }
            sum += rowSum;
        }

        // 세로 숫자 계산
        for (int j = 0; j < M; j++) {
            int colSum = 0;
            for (int i = 0; i < N; i++) {
                if (!used[i][j]) colSum = colSum * 10 + arr[i][j];
                else {
                    sum += colSum;
                    colSum = 0;
                }
            }
            sum += colSum;
        }

        answer = Math.max(answer, sum);
    }
}
