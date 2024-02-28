package AlgorithmBase2;

import java.util.Arrays;
import java.util.Scanner;

public class P14391B {
    // BOJ 14391 종이 조각
    private static int N, M;
    private static int answer = Integer.MIN_VALUE;
    private static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        arr = new int[N][M];

        for (int i = 0; i < N; i++)
            arr[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();

        solution();
        System.out.println(answer);
    }

    /**
     * bitmask : 특정 칸을 가로 또는 세로로 읽는 모든 경우 탐색
     */
    private static void solution() {
        for (int bit = 0; bit < (1 << N * M); bit++) {
            cal(bit);
        }
    }

    /**
     * 비트마스크 값을 사용하여 가로와 세로 숫자를 계산한다.
     *
     * @param bit 비트마스크 값
     */
    private static void cal(int bit) {
        int sum = 0;

        // 가로 숫자 계산
        for (int i = 0; i < N; i++) {
            int rowSum = 0;
            for (int j = 0; j < M; j++) {
                int index = i * M + j;
                if ((bit & (1 << index)) == 0) {
                    rowSum = rowSum * 10 + arr[i][j];
                } else {
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
                int index = i * M + j;
                if ((bit & (1 << index)) != 0) {
                    colSum = colSum * 10 + arr[i][j];
                } else {
                    sum += colSum;
                    colSum = 0;
                }
            }
            sum += colSum;
        }

        answer = Math.max(answer, sum);
    }
}
