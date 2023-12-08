package D2;

import java.util.Scanner;

public class P1954 {
    // 1954. 달팽이 숫자
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            System.out.println("#" + i);
            solution(sc.nextInt());
        }
    }

    private static void solution(int n) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] arr = new int[n][n];
        int x = -1, y = 0, num = 1, len = n, cnt = 0;

        while(num <= n*n) {
            for(int i=0; i<len; i++) {
                x += dx[cnt % 4];
                y += dy[cnt % 4];
                arr[y][x] = num;
                num++;
            }
            cnt++;
            if(cnt%2 == 1) len--;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

}
