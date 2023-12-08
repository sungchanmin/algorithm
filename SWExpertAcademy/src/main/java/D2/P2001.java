package D2;

import java.util.Scanner;

public class P2001 {
    // 2001. 파리 퇴치
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int p = 1; p <= t; p++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }

            System.out.println("#" + p + " " + solution(n, m, arr));
        }
    }

    private static int solution(int n, int m, int[][] arr) {
        int max = 0;

        for(int i=0; i<=n-m; i++) {
            for(int j=0; j<=n-m; j++) {
                int sum = 0;

                for(int k=0; k<m; k++) {
                    for(int l=0; l<m; l++) {
                        sum += arr[i+k][j+l];
                    }
                }

                max = Math.max(max, sum);
            }
        }

        return max;
    }
}