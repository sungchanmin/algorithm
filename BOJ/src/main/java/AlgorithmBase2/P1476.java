package AlgorithmBase2;

import java.util.Scanner;

public class P1476 {
    // BOJ 1476 날짜 계싼
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int s = sc.nextInt();
        int c = sc.nextInt();

        int[][][] arr = new int[16][29][20];

        int year = 1;
        int E = 0;
        int S = 0;
        int M = 0;

        for (int i = 0; i < 7980; i++) {
            arr[(E++) % 15 + 1][(S++) % 28 + 1][(M++) % 19 + 1] = year++;
        }

        System.out.println(arr[e][s][c]);
    }
}