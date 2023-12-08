package D2;

import java.util.Scanner;

public class P1974 {
    // 1974. 스도쿠 검증
    private static final int SIZE = 9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] arr = new int[SIZE][SIZE];

        for (int test_case = 1; test_case <= T; test_case++) {

            for(int i=0; i<SIZE; i++) {
                for(int j=0; j<SIZE; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            System.out.println("#" + test_case + " " + solution(arr));
        }
    }

    private static int solution(int[][] arr) {
        for(int i=0; i<SIZE; i++) {
            int[] ch1 = new int[SIZE + 1];
            int[] ch2 = new int[SIZE + 1];
            for (int j = 0; j < SIZE; j++) {
                if(ch1[arr[i][j]] != 0 || ch2[arr[j][i]] != 0) return 0;
                ch1[arr[i][j]] = 1;
                ch2[arr[j][i]] = 1;
            }
        }

        for(int i=0; i<SIZE; i+=3) {
            for(int j=0; j<SIZE; j+=3) {
                int[] ch = new int[SIZE + 1];
                for(int x=0; x<3; x++) {
                    for(int y=0; y<3; y++) {
                        if(ch[arr[i+x][j+y]] != 0) return 0;
                        ch[arr[i+x][j+y]] = 1;
                    }
                }
            }
        }

        return 1;
    }
}
