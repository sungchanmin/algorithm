package chapter02.Array.no21;

import java.util.Scanner;

public class GridMaxSum {
    private static int solution(int n, String[][] strings) {
        int answer = 0;
        int[] sum = new int[2*n + 2];

        // 가로 합 구하기
        for(int i=0; i<n; i++) {
            for(String s : strings[i]) sum[i] += Integer.parseInt(s);

            // 새로 합 구하기
            for(int j=0; j<n; j++) {
                sum[n + j] += Integer.parseInt(strings[i][j]);

                // 대각합 구하기
                if(i == j) sum[2 * n] += Integer.parseInt(strings[i][j]);
                else if(i + j == n - 1) sum[2 * n + 1] += Integer.parseInt(strings[i][j]);

                if(n % 2 != 0 && i == n/2 && j == n/2) sum[2 * n + 1] += Integer.parseInt(strings[i][j]);
            }
        }

        for(int i : sum) {
            if(answer < i) answer = i;
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
