package D2;

import java.util.Scanner;

public class P1979 {
    // 1979. 어디에 단어가 들어갈 수 있을까
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            System.out.println("#" + test_case + " " + solution(n, k, arr));
        }
    }

    private static int solution(int n, int k, int[][] arr) {
        int answer = 0;

        for(int i=0; i<n; i++) {
            int cnt1 = 0;
            int cnt2 = 0;
            for(int j=0; j<n; j++) {
                if(arr[i][j] == 1) cnt1++;
                else {
                    if(cnt1 == k) answer++;
                    cnt1 = 0;
                }

                if(arr[j][i] == 1) cnt2++;
                else {
                    if(cnt2 == k) answer++;
                    cnt2 = 0;
                }
            }
            if(cnt1 == k) answer++;
            if(cnt2 == k) answer++;
        }
        return answer;
    }
}