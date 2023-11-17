package D3;

import java.util.Scanner;

public class P1209 {
    // 1209. Sum
    private static final int SIZE = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
            int[][] arr = new int[SIZE][SIZE];

            for(int i=0; i<SIZE; i++) {
                for(int j=0; j<SIZE; j++) arr[i][j] = sc.nextInt();
            }

            System.out.println("#" + test_case + " " + solution(arr));
        }
    }

    private static int solution(int[][] arr) {
        int answer = 0;
        int sum1, sum2, sum3 = 0, sum4 =0;

        for(int i=0; i<SIZE; i++) {
            sum1 = 0;
            sum2 = 0;
            for(int j=0; j<SIZE; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            sum3 += arr[i][i];
            sum4 += arr[i][SIZE-1-i];
            answer = Math.max(answer, Math.max(sum1, sum2));
        }

        return Math.max(answer, Math.max(sum3, sum4));
    }
}
