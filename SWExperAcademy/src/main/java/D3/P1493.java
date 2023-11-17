package D3;

import java.util.Scanner;

public class P1493 {
    // 1493. 수의 새로운 연산
    private static final int SIZE = 300;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[][] arr = new int[SIZE][SIZE];

        int n = 1;

        for(int i=1; i<SIZE; i++) {
            int x = 1;
            int y = i;

            while(y > 0) {
                arr[x][y] = n;
                n++;
                x++;
                y--;
            }
        }


        for (int test_case = 1; test_case <= T; test_case++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println("#" + test_case + " " + solution(arr, a, b));
        }
    }

    private static int solution(int[][] arr, int a, int b) {
        int x1=-1, y1=-1, x2=-1, y2=-1;
        boolean p1 = false, p2 = false;

        for(int i=1; i<SIZE; i++) {
            int x = 1;
            int y = i;

            while(y > 0) {
                if(arr[x][y] == a) {
                    x1 = x;
                    y1 = y;
                    p1 = true;
                }
                if(arr[x][y] == b) {
                    x2 = x;
                    y2 = y;
                    p2 = true;
                }
                x++;
                y--;

                if(p1 && p2) return arr[x1 + x2][y1 + y2];
            }
        }

        return arr[x1 + x2][y1 + y2];
    }
}
