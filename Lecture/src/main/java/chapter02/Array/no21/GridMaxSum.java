package chapter02.Array.no21;

import java.util.Scanner;

public class GridMaxSum {
    private static int solution(int n, String[][] strings) {
        int answer = 0;
        int[] sum = new int[2*n + 2];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // 가로, 세로합 구하기
                sum[i] += Integer.parseInt(strings[i][j]);
                sum[n + i] += Integer.parseInt(strings[j][i]);

                // 대각합 구하기
                if(i == j) sum[2 * n] += Integer.parseInt(strings[i][j]);
                else if(i + j == n - 1) sum[2 * n + 1] += Integer.parseInt(strings[i][j]);

                if(n % 2 != 0 && i == n/2 && j == n/2) sum[2 * n + 1] += Integer.parseInt(strings[i][j]);
            }
        }

        for(int i : sum) {
            answer = Math.max(i, answer);
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[][] strings = new String[n][];

        for(int i=0; i<n; i++) {
            strings[i] = sc.nextLine().split(" ");
        }

        System.out.println(solution(n, strings));
    }
}
