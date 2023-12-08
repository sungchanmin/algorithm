package D3;

import java.util.Scanner;

public class P1215 {
    // 1215. 회문1
    private static final int SIZE = 8;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(sc.nextLine());
            char[][] arr = new char[SIZE][SIZE];

            for(int i=0; i<SIZE; i++) {
                arr[i] = sc.nextLine().toCharArray();
            }

            System.out.println("#" + test_case + " " + solution(n, arr));
        }
    }

    private static int solution(int n, char[][] arr) {
        int answer = 0;

        for(int i=0; i<SIZE; i++) {
            for(int j=0; j<=SIZE-n; j++) {
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                for(int k=0; k<n; k++) {
                    sb1.append(arr[i][j+k]);
                    sb2.append(arr[j+k][i]);
                }
                if(sb1.toString().equals(sb1.reverse().toString())) {
                    answer++;
                }
                if(sb2.toString().equals(sb2.reverse().toString())) {
                    answer++;
                }
            }
        }

        return answer;
    }
}